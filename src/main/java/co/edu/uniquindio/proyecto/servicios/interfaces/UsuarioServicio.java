package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO) throws Exception;

    int registrarUsuario(UsuarioDTO usuarioDTO) throws Exception;

    UsuarioGetDTO actualizarUsuario(int idUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminarUsuario(int idUsuario) throws Exception;

    UsuarioGetDTO obtenerUsuario(int idUsuario) throws Exception;

    Usuario obtener(int idUsuario) throws Exception;
}
