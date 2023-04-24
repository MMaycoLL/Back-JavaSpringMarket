package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.MetodoPago;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@Transactional

public class CompraTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Autowired
    private CompraServicio compraServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompraTest() {
        try {
            // Obtener el usuario existente
            int idUsuario = 2;
            Usuario usuario = usuarioRepo.findById(idUsuario).get();

            // Obtener un detalle de compra existente del dataset
            int idDetalleCompra = 3;
            DetalleCompra detalleCompra = detalleCompraRepo.findById(idDetalleCompra).get();

            // Crear un objeto DTO con los datos de la compra a crear
            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
            detalleCompraDTO.setCantidad(detalleCompra.getCantidad());
            detalleCompraDTO.setIdProducto(detalleCompra.getProducto().getIdProducto());
            detalleCompraDTO.setPrecioCompra(detalleCompra.getPrecioCompra());
            CompraDTO compraDTO = new CompraDTO(
                    MetodoPago.TARJETA_CREDITO,
                    usuario.getIdPersona(),
                    Collections.singletonList(detalleCompraDTO),
                    4);

            // Crear la compra a partir del DTO
            int idCompra = compraServicio.crearCompra(compraDTO);

            // Verificar que la compra se creó correctamente
            CompraGetDTO compraGetDTO = compraServicio.obtenerCompra(idCompra);
            Assertions.assertEquals(usuario.getIdPersona(), compraGetDTO.getIdUsuario());
            Assertions.assertEquals(detalleCompra.getPrecioCompra() * detalleCompra.getCantidad(), compraGetDTO.getTotalCompra());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasUsuarioTest() {
        try {
            int idUsuario = 1;

            List<CompraGetDTO> compras = compraServicio.listarComprasUsuarios(idUsuario);

            Assertions.assertEquals(2, compras.size());
            Assertions.assertEquals(idUsuario, compras.get(0).getIdUsuario());
            Assertions.assertEquals(idUsuario, compras.get(1).getIdUsuario());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraTest() {
        try {
            int idCompra = 3;

            CompraGetDTO compra = compraServicio.obtenerCompra(idCompra);

            Assertions.assertEquals(idCompra, compra.getIdCompra());
            Assertions.assertEquals(MetodoPago.PAYPAL, compra.getMetodoPago());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



