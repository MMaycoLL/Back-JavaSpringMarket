package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.ProductoModerador;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductoModeradorImpl implements ProductoModeradorServicio {

    private final ProductoServicio productoServicio;
    private final ProductoModeradorRepo productoModeradorRepo;
    private final ModeradorServicio moderadorServicio;
    private final EmailServicio emailServicio;


    public void aprobarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
        registrarEvento(productoModeradorDTO, EstadoProducto.ACTIVO);
    }


    public void rechazarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
        registrarEvento(productoModeradorDTO, EstadoProducto.INACTIVO);
    }


    private void registrarEvento(ProductoModeradorDTO productoModeradorDTO, EstadoProducto estadoProducto) throws Exception {

        // Actualizar el estado del producto
        Producto producto = productoServicio.obtener(productoModeradorDTO.getIdProducto());
        productoServicio.actualizarPorEstado(producto.getIdProducto(), estadoProducto);

        // Crear el producto moderador
        ProductoModerador productoModerador = new ProductoModerador();
        productoModerador.setProducto(producto);
        productoModerador.setFechaAutorizacion(LocalDateTime.now());
        productoModerador.setMotivo(productoModeradorDTO.getMotivo());
        productoModerador.setModerador(moderadorServicio.obtenerModeradorPorId(productoModeradorDTO.getIdModerador()));
        productoModerador.setEstadoAutorizacion(estadoProducto);
        productoModeradorRepo.save(productoModerador);

        // Enviar correo electrónico
        enviarCorreo(productoModeradorDTO, estadoProducto);
    }

    private void enviarCorreo(ProductoModeradorDTO productoModeradorDTO, EstadoProducto estadoProducto) throws Exception {
        Producto producto = productoServicio.obtener(productoModeradorDTO.getIdProducto());
        String saludo = "Hola " + producto.getUsuario().getNombreCompleto() + ",";
        String mensaje = "Solo queríamos informarte que tu producto " + producto.getNombreProducto() + " ha sido " + estadoProducto + " por nuestro equipo de moderación con el siguiente motivo: " + productoModeradorDTO.getMotivo() + ".";
        String mensajeFinal = "Gracias por usar nuestro servicio, ¡nos encanta ayudarte a publicar tus productos en línea!";

        String asunto;
        if (estadoProducto == EstadoProducto.ACTIVO) {
            asunto = "Tu producto " + producto.getNombreProducto() + " ha sido aprobado";
        } else {
            asunto = "Tu producto " + producto.getNombreProducto() + " ha sido rechazado";
        }

        EmailDTO emailDTO = new EmailDTO(asunto, saludo + "\n\n" + mensaje + "\n\n" + mensajeFinal, producto.getUsuario().getEmail());
        emailServicio.enviarEmail(emailDTO);
    }
}
