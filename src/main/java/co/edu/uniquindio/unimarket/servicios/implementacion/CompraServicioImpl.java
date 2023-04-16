package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.CompraNoEncontradaException;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;
    private final EnvioServicio envioServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setMetodoPago(compraDTO.getMetodoPago());
        compra.setUsuario(usuarioServicio.obtener(compraDTO.getIdPersona()));
        compra.setEnvio(envioServicio.obtener(compraDTO.getIdEnvio()));
        compra.setFechaCompra(LocalDate.now().atStartOfDay());

        float total = 0;

        for (DetalleCompraDTO dc : compraDTO.getDetalleCompraDTO()) {
            total += dc.getPrecioCompra() * dc.getCantidad();
        }

        compra.setTotalCompra(total);

        return compraRepo.save(compra).getIdCompra();
    }


    @Override
    public List<CompraGetDTO> listarComprasUsuarios(int idUsuario) {
        List<Compra> compras = compraRepo.findByUsuarioIdUsuario(idUsuario);
        List<CompraGetDTO> compraGetDTOs = new ArrayList<>();

        for (Compra compra : compras) {
            CompraGetDTO dto = convertir(compra);
            compraGetDTOs.add(dto);
        }

        return compraGetDTOs;
    }

    public Compra obtener(int idCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(idCompra);

        if (compra.isEmpty()) {
            throw new CompraNoEncontradaException("La compra no existe");
        }

        return compra.get();
    }

    @Override
    public CompraGetDTO obtenerCompra(int idCompra) {
        Compra compra = compraRepo.findById(idCompra).orElse(null);
        if (compra == null) {
            return null;
        }

        return convertir(compra);
    }

    private CompraGetDTO convertir(Compra compra) {
        CompraGetDTO dto = new CompraGetDTO();
        dto.setIdCompra(compra.getIdCompra());
        dto.setFechaCompra(compra.getFechaCompra());
        dto.setTotalCompra(compra.getTotalCompra());
        dto.setIdUsuario(compra.getUsuario().getIdPersona());
        dto.setMetodoPago(compra.getMetodoPago());

        List<DetalleCompraDTO> detalleCompraDTOs = new ArrayList<>();
        if (compra.getDetalleCompra() != null) { // Verificar si la lista es nula
            for (DetalleCompra detalleCompra : compra.getDetalleCompra()) {
                DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
                detalleCompraDTO.setCantidad(detalleCompra.getCantidad());
                detalleCompraDTO.setPrecioCompra(detalleCompra.getPrecioCompra());
                detalleCompraDTO.setIdProducto(detalleCompra.getProducto().getIdProducto());
                detalleCompraDTOs.add(detalleCompraDTO);
            }
        }
        dto.setDetalleCompraDTO(detalleCompraDTOs);
        return dto;
    }


}

