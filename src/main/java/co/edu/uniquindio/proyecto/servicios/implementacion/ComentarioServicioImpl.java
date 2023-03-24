package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;

import java.util.List;

public class ComentarioServicioImpl implements ComentarioServicio {
    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) {
        return 0;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(int idProducto) {
        return null;
    }
}
