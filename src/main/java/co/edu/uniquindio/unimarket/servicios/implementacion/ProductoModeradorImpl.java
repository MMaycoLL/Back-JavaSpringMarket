package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.ProductoModerador;
import co.edu.uniquindio.unimarket.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductoModeradorImpl implements ProductoModeradorServicio {


    private final ProductoServicioImpl productoServicio;
    private final ModeradorServicioImpl moderadorServicio;
    private final ProductoModeradorRepo productoModeradorRepo;

    @Override
    public void aprobarRechazar(ProductoModeradorDTO productoModeradorDTO) throws Exception {
        Producto producto = productoServicio.obtener(productoModeradorDTO.getIdProducto());
        producto.setEstadoProducto(productoModeradorDTO.getEstadoAutorizacion());
        productoServicio.actualizarPorEstado(producto.getIdProducto(), productoModeradorDTO.getEstadoAutorizacion());

        // Busca el registro existente para el producto
        ProductoModerador productoModeradorExistente = productoModeradorRepo.findByProductoId(productoModeradorDTO.getIdProducto());

        if (productoModeradorExistente != null) {
            // Si el registro existe, actualiza los campos y guarda los cambios
            productoModeradorExistente.setFechaAutorizacion(LocalDateTime.now());
            productoModeradorExistente.setMotivo(productoModeradorDTO.getMotivo());
            productoModeradorExistente.setModerador(moderadorServicio.obtenerModeradorPorId(productoModeradorDTO.getIdModerador()));
            productoModeradorExistente.setEstadoAutorizacion(productoModeradorDTO.getEstadoAutorizacion());
            productoModeradorRepo.save(productoModeradorExistente);
        } else {
            // Si el registro no existe, crea uno nuevo y lo guarda
            ProductoModerador productoModerador = new ProductoModerador();
            productoModerador.setProducto(producto);
            productoModerador.setFechaAutorizacion(LocalDateTime.now());
            productoModerador.setMotivo(productoModeradorDTO.getMotivo());
            productoModerador.setModerador(moderadorServicio.obtenerModeradorPorId(productoModeradorDTO.getIdModerador()));
            productoModerador.setEstadoAutorizacion(productoModeradorDTO.getEstadoAutorizacion());
            productoModeradorRepo.save(productoModerador);
        }
    }
}
