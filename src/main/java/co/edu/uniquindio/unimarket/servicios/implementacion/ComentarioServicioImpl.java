package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Comentario;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ProductoServicio productoServicio;
    private final UsuarioServicio usuarioServicio;
    private final ComentarioRepo comentarioRepo;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        // Verificar que el producto y el usuario existen
        Producto producto = productoServicio.obtener(comentarioDTO.getIdProducto());
        Usuario usuario = usuarioServicio.obtener(comentarioDTO.getIdUsuario());

        // Crear un nuevo comentario
        Comentario comentario = new Comentario();
        comentario.setComentario(comentarioDTO.getComentario());
        comentario.setFechaComentario(LocalDateTime.now());
        comentario.setProducto(producto);
        comentario.setUsuario(usuario);

        // Guardar el comentario en la base de datos y devolver su ID
        return comentarioRepo.save(comentario).getIdComentario();
    }


    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(int idProducto) throws Exception {
        // Buscar el producto correspondiente en la base de datos
        Producto producto = productoServicio.obtener(idProducto);

        // Obtener la lista de comentarios del producto
        List<Comentario> comentarios = producto.getComentario();

        /*
        Bucle for para convertir cada comentario en un objeto de tipo ComentarioGetDTO
        utilizando el método "convertir(comentario)"
         */
        List<ComentarioGetDTO> comentarioDTO = new ArrayList<>();
        for (Comentario comentario : comentarios) {
            ComentarioGetDTO dto = convertir(comentario);
            comentarioDTO.add(dto);
        }
        return comentarioDTO;
    }


    // Método auxiliar para convertir un objeto de tipo Comentario a ComentarioGetDTO
    private ComentarioGetDTO convertir(Comentario comentario) {

        ComentarioGetDTO comentarioDTO = new ComentarioGetDTO();
        comentarioDTO.setIdComentario(comentario.getIdComentario());
        comentarioDTO.setComentario(comentario.getComentario());
        comentarioDTO.setFechaComentario(comentario.getFechaComentario());

        return comentarioDTO;
    }

}
