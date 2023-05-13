package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoModeradorImpl implements ProductoModeradorServicio {


    private final ProductoServicio productoServicio;
    private final EmailServicio emailServicio;

    public void aprobarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
        Producto producto = productoServicio.obtener(productoModeradorDTO.getIdProducto());
        productoServicio.actualizarPorEstado(producto.getIdProducto(), EstadoProducto.ACTIVO);
        enviarCorreo(producto, EstadoProducto.ACTIVO, productoModeradorDTO.getMotivo());
    }

    public void rechazarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
        Producto producto = productoServicio.obtener(productoModeradorDTO.getIdProducto());
        productoServicio.actualizarPorEstado(producto.getIdProducto(), EstadoProducto.INACTIVO);
        enviarCorreo(producto, EstadoProducto.INACTIVO, productoModeradorDTO.getMotivo());
    }

    private void enviarCorreo(Producto producto, EstadoProducto estadoProducto, String motivo) throws Exception {
        String saludo = "Hola " + producto.getUsuario().getNombreCompleto() + ",";
        String mensaje = "Solo queríamos informarte que tu producto " + producto.getNombreProducto() + " ha sido " + estadoProducto + " por nuestro equipo de moderación con el siguiente motivo: " + motivo + ".";
        String mensajeFinal = "Gracias por usar nuestro servicio, ¡nos encanta ayudarte a publicar tus productos en línea!";

        String asunto;
        if (estadoProducto == EstadoProducto.ACTIVO) {
            asunto = "Tu producto " + producto.getNombreProducto() + " ha sido aprobado";
        } else {
            asunto = "Tu producto " + producto.getNombreProducto() + " ha sido rechazado";
        }

        emailServicio.enviarEmail(new EmailDTO(asunto, saludo + "\n\n" + mensaje + "\n\n" + mensajeFinal, producto.getUsuario().getEmail()));
    }

}
