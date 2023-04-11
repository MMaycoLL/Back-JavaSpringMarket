package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.MetodoPago;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional

public class CompraTest {


    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private CompraServicio compraServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompraTest() throws Exception {

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasUsuarioTest() throws Exception {

        int idUsuario = 1;

        List<CompraGetDTO> compras = compraServicio.listarComprasUsuarios(idUsuario);

        Assertions.assertEquals(2, compras.size());
        Assertions.assertEquals(idUsuario, compras.get(0).getIdUsuario());
        Assertions.assertEquals(idUsuario, compras.get(1).getIdUsuario());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraTest() throws Exception {

        int idCompra = 3;

        CompraGetDTO compra = compraServicio.obtenerCompra(idCompra);

        Assertions.assertEquals(idCompra, compra.getIdCompra());
        Assertions.assertEquals(MetodoPago.PAYPAL, compra.getMetodoPago());
    }

}



