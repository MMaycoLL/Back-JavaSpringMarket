package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuarioTest() {
        try {


            // se crea el usuario con el servicio de crear usuario
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Pepito 4",
                    "pepe12@email.com",
                    "12300007",
                    "Calle 12 #12",
                    "343",
                    "1234");

            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            Usuario usuario = usuarioServicio.obtener(codigo);
            System.out.println(usuario.getContrasenia());

        /*
        Se espera que si se registra correctamente entonces el servicio
        no debe retornar 0
         */
            Assertions.assertNotEquals(0, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuarioTest() {

        try {

            // Busca un usuario existente en el dataset para eliminarlo
            UsuarioGetDTO usuarioDTO = usuarioServicio.obtenerUsuario(1);

            // Elimina el usuario encontrado
            int usuarioEliminado = usuarioServicio.eliminarUsuario(usuarioDTO.getIdUsuario());

            // Verifica que el usuario fue eliminado
            Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(usuarioEliminado));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuarioTest() {

        try {

            // Busca un usuario existente en el dataset para modificarlo
            UsuarioGetDTO usuarioDTO = usuarioServicio.obtenerUsuario(1);

            // Crear un objeto de tipo usuarioDTO con los datos a actualizar
            UsuarioDTO usuarioActualizado = new UsuarioDTO();
            usuarioActualizado.setCedula("12300010");

            // Actualiza el usuario encontrado
            UsuarioGetDTO usuarioActualizadoDTO = usuarioServicio.actualizarUsuario(usuarioDTO.getIdUsuario(), usuarioActualizado);

            // Verifica que el usuario fue actualizado
            Assertions.assertEquals("12300011", usuarioActualizadoDTO.getCedula());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuarioTest() {
        try {

            // Busca un usuario existente en el dataset
            UsuarioGetDTO usuario = usuarioServicio.obtenerUsuario(1);

            // Verifica que el usuario fue encontrado
            Assertions.assertEquals("pepito perez", usuario.getNombreCompleto());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
