package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional

public class CalificacionTest {

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Autowired
    private CalificacionServicio calificacionServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearCalificacionTest() {
        try {
            // Crear calificación
            CalificacionDTO calificacionDTO = new CalificacionDTO();
            calificacionDTO.setComentarioCalificacion("Muy buen producto");
            calificacionDTO.setValorCalificaion(3);

            // Obtener detalle compra para asociar a la calificación
            DetalleCompra detalleCompra = detalleCompraRepo.findById(2).orElse(null);

            // Asociar producto compra a la calificación
            calificacionDTO.setIdDetalleCompra(detalleCompra.getIdDetalleCompra());

            // Asociar ID de usuario o persona a la calificación
            calificacionDTO.setIdUsuario(2);

            // Guardar calificación
            int calificacion = calificacionServicio.crearCalificacion(calificacionDTO);

            // Verificar que la calificación fue creada exitosamente
            Assertions.assertNotEquals(0, calificacion);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("No se pudo crear la calificación");
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void promedioCalificacionTest() {
        try {
            // ID de usuario o persona que realiza la prueba
            int idUsuario = 2;

            // Obtener producto compra para asociar a la calificación
            DetalleCompra detalleCompra = detalleCompraRepo.findById(1).orElse(null);

            // Verificar que el detalleCompra existe
            if (detalleCompra == null) {
                Assertions.fail("No se encontró un detalle compra  con ID 1");
            }

            // Obtener promedio de calificaciones
            double promedio = calificacionServicio.promedioCalificacion(detalleCompra.getProducto().getIdProducto());

            // Verificar que el promedio es correcto
            Assertions.assertEquals(1.0, promedio);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("No se pudo obtener el promedio de calificaciones");
        }
    }

}
