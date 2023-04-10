package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static java.sql.DriverManager.println;

@SpringBootTest
@Transactional

public class CalificacionTest {

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Autowired
    private CalificacionServicio calificacionServicio;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCalificacionTest() throws Exception {
        // ID de usuario o persona que realiza la prueba
        //int idUsuario = 2;

        // Crear calificación
        CalificacionDTO calificacionDTO = new CalificacionDTO();
        calificacionDTO.setComentarioCalificacion("Muy buen producto");
        calificacionDTO.setValorCalificaion(3);

        // Obtener producto compra para asociar a la calificación
        DetalleCompra detalleCompra = detalleCompraRepo.findById(3).orElse(null);

        // Verificar que el detalleCompra existe
        if (detalleCompra == null) {
            Assertions.fail("No se encontró el producto compra con ID 1");
        }
println("detalleCompra.getIdProductoCompra() = " + detalleCompra.getProducto().getNombreProducto());
        // Asociar producto compra a la calificación
        calificacionDTO.setIdProductoCompra(detalleCompra.getIdProductoCompra());

        // Asociar ID de usuario o persona a la calificación
        calificacionDTO.setIdUsuario(2);

        // Guardar calificación
        int calificacion = calificacionServicio.crearCalificacion(calificacionDTO);

        // Verificar que la calificación fue creada exitosamente
        Assertions.assertNotEquals(0, calificacion);
    }





}
