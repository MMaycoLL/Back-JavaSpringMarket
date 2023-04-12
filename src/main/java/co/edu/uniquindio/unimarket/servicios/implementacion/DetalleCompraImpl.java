package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DetalleCompraImpl implements DetalleCompraServicio {

    private final DetalleCompraRepo detalleCompraRepo;

    @Override
    public DetalleCompraGetDTO obtenerDetalleCompra(int idDetalleCompra) throws Exception {
return convertir(obtener(idDetalleCompra));
    }


    public DetalleCompra obtener(int idDetalleCompra) throws Exception {
        Optional<DetalleCompra> detalleCompra = detalleCompraRepo.findById(idDetalleCompra);
        if (!detalleCompra.isPresent()) {
            throw new Exception("No se encontro el detalle de compra");
        }
        return detalleCompra.get();
    }

    private DetalleCompraGetDTO convertir (DetalleCompra detalleCompra){

        DetalleCompraGetDTO detalleCompraGetDTO = new DetalleCompraGetDTO();
        detalleCompraGetDTO.setCantidad(detalleCompra.getCantidad());
        detalleCompraGetDTO.setPrecioCompra(detalleCompra.getPrecioCompra());
        detalleCompraGetDTO.setIdProducto(detalleCompra.getProducto().getIdProducto());

        return detalleCompraGetDTO;
    }

}
