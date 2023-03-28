package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private UsuarioServicio usuarioServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception{
        Compra compra = new Compra();
        compra.setMetodoPago(compraDTO.getMetodoPago());
        compra.setUsuario(usuarioServicio.obtener(compraDTO.getIdPersona()));
        //compra.setDetalleCompra(compraDTO.getDetalleCompraDTO());


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
