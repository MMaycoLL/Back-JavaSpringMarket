package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;

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
