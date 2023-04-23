package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.DetalleCompraNotFoundException;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.UnidadesNoDisponiblesException;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DetalleCompraImpl implements DetalleCompraServicio {


    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoServicio productoServicio;


    @Override
    public DetalleCompra crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception {

        validarUnidadesDisponibles(detalleCompraDTO);

        Producto producto = productoServicio.obtener(detalleCompraDTO.getIdProducto());

        validarUnidadesDisponibles(detalleCompraDTO);

        productoServicio.actualizarPorUnidades(producto.getIdProducto(), producto.getUnidadesDisponibles() - detalleCompraDTO.getCantidad());

        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCantidad(detalleCompraDTO.getCantidad());
        detalleCompra.setPrecioCompra(detalleCompraDTO.getPrecioCompra());
        detalleCompra.setProducto(producto);

        return detalleCompraRepo.save(detalleCompra);
    }

    @Override
    public DetalleCompraGetDTO obtenerDetalleCompra(int idDetalleCompra) throws Exception {
        return convertir(obtener(idDetalleCompra));
    }


    public DetalleCompra obtener(int idDetalleCompra) throws Exception {
        Optional<DetalleCompra> detalleCompra = detalleCompraRepo.findById(idDetalleCompra);
        if (detalleCompra.isEmpty()) {
            throw new DetalleCompraNotFoundException("No se encontro el detalle de compra");
        }
        return detalleCompra.get();
    }

    private void validarUnidadesDisponibles(DetalleCompraDTO detalleCompraDTO) throws Exception {
        Producto producto = productoServicio.obtener(detalleCompraDTO.getIdProducto());
        if (producto.getUnidadesDisponibles() < detalleCompraDTO.getCantidad())
            throw new UnidadesNoDisponiblesException("La cantidad de unidades disponibles es menor a la solicitada");
    }


    private DetalleCompraGetDTO convertir(DetalleCompra detalleCompra) {

        DetalleCompraGetDTO detalleCompraGetDTO = new DetalleCompraGetDTO();
        detalleCompraGetDTO.setCantidad(detalleCompra.getCantidad());
        detalleCompraGetDTO.setPrecioCompra(detalleCompra.getPrecioCompra());
        detalleCompraGetDTO.setIdProducto(detalleCompra.getProducto().getIdProducto());

        return detalleCompraGetDTO;
    }

}
