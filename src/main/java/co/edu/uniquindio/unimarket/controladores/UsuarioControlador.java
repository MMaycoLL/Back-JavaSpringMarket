package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
        return 0;
    }

    public UsuarioGetDTO actualizarUsuario(int idUsuario, UsuarioDTO usuarioDTO) throws Exception {
        return null;
    }

    public int eliminarUsuario(int idUsuario) throws Exception {
        return 0;
    }

    public UsuarioGetDTO obtenerUsuario(int idUsuario) throws Exception {
        return null;
    }
}
