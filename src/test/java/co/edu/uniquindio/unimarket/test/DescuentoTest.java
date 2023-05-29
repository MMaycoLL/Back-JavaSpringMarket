package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

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

}



