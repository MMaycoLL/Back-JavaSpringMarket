package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearUsuarioTest() throws Exception {

        // se crea el usuario con el servicio de crear usuario
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 4",
                "pepe12@email.com",
                "12300007",
                "Calle 12 #12",
                "343",
                "1234");

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);
        /*
        Se espera que si se registra correctamente entonces el servicio
        no debe retornar 0
         */
        Assertions.assertNotEquals(0, codigo);

    }

    @Test
    public void eliminarUsuarioTest() throws Exception {

        // para eliminar el usuario se debe crear primero

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 4",
                "pepe12@email.com",
                "12300007",
                "Calle 12 #12",
                "343",
                "1234");

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        // Una vez creado el usuario se procede a eliminarlo

        int codigoBorrado = usuarioServicio.eliminarUsuario(codigo);

        /*
        Si intentamos buscar un usuario con el codigo del usuario borrado
        debemos obtener una excepción indicando que ya no existe
         */
        Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(codigoBorrado));

    }


    @Test
    public void actualizarUsuarioTest() throws Exception {

        // Para actualizar el usuario se debe crear primero

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 4",
                "pepe12@email.com",
                "12300007",
                "Calle 12 #12",
                "343",
                "1234");

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        // El servicio de actualizar nos retorna el usuario

        UsuarioGetDTO usuarioActualizado = usuarioServicio.actualizarUsuario(codigo, new UsuarioDTO(
                "Pepito 4",
                "pepe12@email.com",
                "12300007",
                "Calle 12 #12",
                "343",
                "1111"));

        /*
        Se comprueba que ahora el teléfono del usuario no es el que se usó
        cuando se creó inicialmente
         */

        Assertions.assertNotEquals("1234", usuarioActualizado.getTelefono());

    }

    @Test
    public void obtenerUsuarioTest() throws Exception {

        // Para obtener el usuario se debe crear primero

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 4",
                "pepe12@email.com",
                "12300007",
                "Calle 12 #12",
                "343",
                "1234");

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        // Se llama el servicio para obtener el usuario dado su codigo

        UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(codigo);

        /*
        Comprobamos que la dirección que está en la base de datos coincide con la
        que esperamos
         */
        Assertions.assertEquals("Calle 12 #12", usuarioGetDTO.getDireccion());


    }

}
