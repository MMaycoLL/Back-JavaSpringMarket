package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.DescuentoGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.sql.DriverManager.println;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest

public class DescuentoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private DescuentoServicio descuentoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void aplicarDescuentoTest() {

        try {

            // Crea un objeto DescuentoGetDTO con los datos necesarios
            DescuentoGetDTO descuentoGetDTO = new DescuentoGetDTO();
            descuentoGetDTO.setIdProducto(1); // Id de un producto existente en el dataset
            descuentoGetDTO.setPorcentajeDescuento(BigDecimal.valueOf(10)); // Descuento del 10%
            descuentoGetDTO.setFechaInicioDescuento(LocalDate.now()); // Fecha de inicio del descuento es hoy
            descuentoGetDTO.setFechaFinalDescuento(LocalDate.now().plusMonths(2)); // Fecha final del descuento es 2 meses desde hoy

            // Obtiene el producto antes de aplicar el descuento
            ProductoGetDTO productoObtenido = productoServicio.obtenerProducto(1); // Id del producto al que se le aplicó el descuento
            System.out.println("Precio actual del producto antes del descuento: " + productoObtenido.getPrecioActual());

            // Aplica el descuento al producto
            descuentoServicio.aplicarDescuento(descuentoGetDTO);

            // Obtiene el producto actualizado
            ProductoGetDTO productoDespuesGetDTO = productoServicio.obtenerProducto(1); // Id del producto al que se le aplicó el descuento

            // Verifica que el descuento fue aplicado exitosamente
            System.out.println("Precio actual del producto después del descuento: " + productoDespuesGetDTO.getPrecioActual());
            Assertions.assertTrue(Math.abs(productoDespuesGetDTO.getPrecioActual() - 45000) < 0.00001); // Precio original - 10% de descuento

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}



