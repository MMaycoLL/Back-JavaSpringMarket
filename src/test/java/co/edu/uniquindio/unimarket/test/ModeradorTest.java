package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class ModeradorTest {

    private ProductoServicio productoServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void autorizarProductoTest() throws Exception {

        // Autorizar un producto existente del dataset
        productoServicio.actualizarPorEstado(1, EstadoProducto.ACTIVO);



    }

}
