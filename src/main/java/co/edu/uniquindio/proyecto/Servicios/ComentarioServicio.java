package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO);

    int listarComentarios(int codigoProducto);

}
