package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.MetodoPago;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class CompraTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private CompraServicio compraServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompraTest() {

    }
}



