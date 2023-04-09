package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private UsuarioServicio usuarioServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setMetodoPago(compraDTO.getMetodoPago());
        compra.setUsuario(usuarioServicio.obtener(compraDTO.getIdPersona()));

        double total = 0;

        for (DetalleCompraDTO dc : compraDTO.getDetalleCompraDTO()) {
            total += dc.getPrecioCompra() * dc.getCantidad();
        }


        return compraRepo.save(compra).getIdCompra();

    }

    @Override
    public List<CompraGetDTO> listarComprasUsuarios(int idUsuario) {

        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int idCompra) {

        return null;
    }

}
