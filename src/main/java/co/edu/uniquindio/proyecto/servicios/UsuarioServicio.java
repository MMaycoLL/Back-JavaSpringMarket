package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO);

    int registrarUsuario(UsuarioDTO usuarioDTO);

    int actualizarUsuario(int idUsuario, UsuarioDTO usuarioDTO);

    int eliminarUsuario(int idUsuario);

    UsuarioGetDTO obtenerUsuario(int idUsuario);


}
