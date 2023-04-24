package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.implementacion.ProductoModeradorImpl;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional

public class ProductoModeradorTest {

    @Autowired
    private ProductoModeradorImpl productoModeradorImpl;

    @Autowired
    private ProductoServicio productoServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void aprobarProductoTest() {
        try {
            ProductoModeradorDTO productoModeradorDTO = new ProductoModeradorDTO();
            productoModeradorDTO.setIdProducto(1);
            productoModeradorDTO.setIdModerador(8);
            productoModeradorDTO.setMotivo("Aprobado");
            productoModeradorImpl.aprobarProducto(productoModeradorDTO);
            Producto producto = productoServicio.obtener(1);
            Assertions.assertEquals(EstadoProducto.ACTIVO, producto.getEstadoProducto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void rechazarProductoTest() {
        try {
            ProductoModeradorDTO productoModeradorDTO = new ProductoModeradorDTO();
            productoModeradorDTO.setIdProducto(1);
            productoModeradorDTO.setIdModerador(8);
            productoModeradorDTO.setMotivo("Rechazado");
            productoModeradorImpl.rechazarProducto(productoModeradorDTO);
            Producto producto = productoServicio.obtener(1);
            Assertions.assertEquals(EstadoProducto.INACTIVO, producto.getEstadoProducto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
