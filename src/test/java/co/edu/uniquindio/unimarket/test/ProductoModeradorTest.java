package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.ProductoModerador;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.implementacion.ProductoModeradorImpl;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest


public class ProductoModeradorTest {

    @Autowired
    private ProductoModeradorImpl productoModeradorImpl;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProductoModeradorRepo productoModeradorRepo;

    @Test
    @Sql("classpath:dataset.sql") // carga los datos de prueba desde el archivo dataset.sql
    public void actualizarPorEstadoTest() throws Exception {

        // Configurar estado inicial
        ProductoModeradorDTO productoModeradorDTO = new ProductoModeradorDTO();
        productoModeradorDTO.setIdProducto(6);
        productoModeradorDTO.setEstadoAutorizacion(EstadoProducto.INACTIVO);
        productoModeradorDTO.setIdModerador(8);
        productoModeradorDTO.setMotivo("Producto no cumple con los estándares de calidad por lo mismo se rechaza");

        // Ejecutar el método que se va a probar
        productoModeradorImpl.aprobarRechazar(productoModeradorDTO);

        // Verificar los resultados
        Producto productoActualizado = productoServicio.obtener(6); // obtener el producto actualizado
        Assertions.assertEquals(EstadoProducto.INACTIVO, productoActualizado.getEstadoProducto()); // verificar que se haya actualizado correctamente

        // Verificar que se haya creado el registro de ProductoModerador correspondiente
        List<ProductoModerador> productoModeradorList = productoModeradorRepo.findAll();
        ProductoModerador productoModeradorCreado = productoModeradorList.get(0); // obtener el registro creado

    }




}
