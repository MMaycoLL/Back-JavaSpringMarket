package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;

public interface UsuarioServicio {
    int registrarUsuario(UsuarioDTO usuarioDTO);

    int actualizarUsuario(int codigo, UsuarioDTO usuarioDTO);

    UsuarioGetDTO obtenerUsuario(int codigo);
}
