package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearUsuarioTest(){

        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito 1", "pepe1@email.com", "12345987", "Calle5678", "343", "1234");
            usuarioServicio.crearUsuario(usuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void eliminarUsuarioTest(){
        try {
            usuarioServicio.eliminarUsuario(1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void actualizarUsuarioTest(){
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito Perez", "pepe1@email.com", "1234", "Calle 123", "2782", "1234");
            usuarioServicio.actualizarUsuario(1, usuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void obtenerUsuarioTest(){
        try {
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(1);
            System.out.println(usuarioGetDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
