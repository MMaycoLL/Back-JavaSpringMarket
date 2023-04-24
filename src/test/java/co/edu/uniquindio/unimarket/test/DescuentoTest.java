package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDescuentoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional

public class DescuentoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private DescuentoServicio descuentoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void aplicarDescuentoTest() {

        try {
            // Crea un objeto DescuentoDTO con los datos necesarios
            DescuentoDTO descuentoDTO = new DescuentoDTO();
            descuentoDTO.setIdProducto(1); // Id de un producto existente en el dataset
            descuentoDTO.setPorcentajeDescuento(10);// Descuento del 10%
            descuentoDTO.setFechaInicioDescuento(LocalDate.now()); // Fecha de inicio del descuento es hoy
            descuentoDTO.setFechaFinalDescuento(LocalDate.now().plusMonths(1)); // Fecha final del descuento es 2 meses desde hoy

            // Aplica el descuento al producto
            descuentoServicio.aplicarDescuento(descuentoDTO);

            // Obtiene el producto actualizado
            ProductoGetDTO productoActualizado = productoServicio.obtenerProducto(1); // Id del producto al que se le aplicó el descuento

            // Verifica que el descuento fue aplicado exitosamente
            Assertions.assertTrue(Math.abs(productoActualizado.getPrecioActual() - 45000) < 0.00001); // Precio original - 10% de descuento

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarDescuentoTest() {
        try {
            // Elimina el descuento del producto con ID 1
            descuentoServicio.eliminarDescuento(1);

            // Verifica que el descuento se eliminó correctamente
            Assertions.assertThrows(DescuentoNoEncontradoException.class, () -> descuentoServicio.obtener(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosConDescuentoTest() {
        try {
            // Obtiene la lista de productos con descuento
            List<ProductoDescuentoDTO> productosConDescuento = descuentoServicio.obtenerProductosConDescuento();

            // Verifica que se encontraron los productos con descuento esperados
            Assertions.assertEquals(1, productosConDescuento.size());
            ProductoDescuentoDTO productoDescuento = productosConDescuento.get(0);
            Assertions.assertEquals(1, productoDescuento.getIdProducto());
            Assertions.assertEquals(50000.0, productoDescuento.getPrecioActual(), 0.00001);
            Assertions.assertEquals(10.0, productoDescuento.getPorcentajeDescuento(), 0.00001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



