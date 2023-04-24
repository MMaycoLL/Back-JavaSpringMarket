package co.edu.uniquindio.unimarket.test;


import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional

public class ComentarioTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentarioTest() {
        try {
            // Obtener un usuario y un producto existente del dataset
            UsuarioGetDTO usuarioDTO = usuarioServicio.obtenerUsuario(1);
            ProductoGetDTO productoDTO = productoServicio.obtenerProducto(3);

            // Crear un comentario para el producto
            ComentarioDTO comentarioDTO = new ComentarioDTO();
            comentarioDTO.setComentario("Excelente producto");
            comentarioDTO.setIdProducto(productoDTO.getIdProducto());
            comentarioDTO.setIdUsuario(usuarioDTO.getIdUsuario());

            // Ejecutar el método crearComentario
            comentarioServicio.crearComentario(comentarioDTO);

            // Verificar que el comentario se haya creado correctamente
            List<ComentarioGetDTO> lista = comentarioServicio.listarComentariosProducto(productoDTO.getIdProducto());
            Assertions.assertEquals(2, lista.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosProductoTest() {
        try {
            // Obtener un producto existente del dataset
            ProductoGetDTO productoDTO = productoServicio.obtenerProducto(4);

            // Ejecutar el método listarComentariosProducto
            List<ComentarioGetDTO> lista = comentarioServicio.listarComentariosProducto(productoDTO.getIdProducto());

            // Verificar que la lista tenga 1 comentario
            Assertions.assertEquals(1, lista.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
