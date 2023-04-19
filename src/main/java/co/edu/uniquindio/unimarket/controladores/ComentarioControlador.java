package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comentario")
@AllArgsConstructor
public class ComentarioControlador {

    private final ComentarioServicio comentarioServicio;


    public void crearComentario(ComentarioDTO comentarioDTO) throws Exception {

    }

    public List<ComentarioGetDTO> listarComentariosProducto(int idProducto) throws Exception {
        return null;
    }

}
