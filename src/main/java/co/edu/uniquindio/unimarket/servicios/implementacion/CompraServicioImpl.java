package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.CompraNoEncontradaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.UnidadesNoDisponiblesException;
import co.edu.uniquindio.unimarket.servicios.interfaces.*;
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
    private final ProductoServicio productoServicio;
    private final EmailServicio emailServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setMetodoPago(compraDTO.getMetodoPago());
        compra.setUsuario(usuarioServicio.obtener(compraDTO.getIdPersona()));
        compra.setEnvio(envioServicio.obtener(compraDTO.getIdEnvio()));
        compra.setFechaCompra(LocalDate.now().atStartOfDay());

        float total = 0;

        for (DetalleCompraDTO detalleCompra : compraDTO.getDetalleCompraDTO()) {
            validarUnidadesDisponibles(detalleCompra);
            total += detalleCompra.getPrecioCompra() * detalleCompra.getCantidad();


            // Enviar email al vendedor
            String emailVendedor = productoServicio.obtener(detalleCompra.getIdProducto()).getUsuario().getEmail();
            String mensaje = "¡Enhorabuena! Has realizado una venta exitosa del siguiente producto:\n\n" + detalleCompra.toString() + "\n\nGracias por ser parte de nuestra plataforma.";
            emailServicio.enviarEmail(new EmailDTO("Venta exitosa", mensaje, emailVendedor));
        }

        compra.setTotalCompra(total);

        // Email para el comprador
        String asunto = "Compra exitosa";
        String detallesCompra = compra.toString();
        String mensajeFinal = "¡Gracias por tu compra! Esperamos que disfrutes de tu producto. Si tienes alguna pregunta o problema, no dudes en ponerte en contacto con nosotros.";
        String mensajeCompleto = detallesCompra + "\n\n" + mensajeFinal;
        emailServicio.enviarEmail(new EmailDTO(asunto, mensajeCompleto, compra.getUsuario().getEmail()));


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

    private void validarUnidadesDisponibles(DetalleCompraDTO detalleCompraDTO) throws Exception {
        Producto producto = productoServicio.obtener(detalleCompraDTO.getIdProducto());
        if (producto.getUnidadesDisponibles() < detalleCompraDTO.getCantidad())
            throw new UnidadesNoDisponiblesException("La cantidad de unidades disponibles es menor a la solicitada");
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

