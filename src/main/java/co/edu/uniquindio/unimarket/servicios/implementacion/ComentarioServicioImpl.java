package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.entidades.Comentario;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.comentario.ComentaiosVaciosException;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
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
    private final EmailServicio emailServicio;

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

        String emailVendedor = producto.getUsuario().getEmail();
        String nombreProducto = producto.getNombreProducto();
        String nombreUsuario = usuario.getNombreCompleto();

        // Mensaje al vendedor
        String cuerpoMensaje = String.format("¡Hola!\n\nSe ha publicado un nuevo comentario en tu producto %s por parte de %s.\n\nComentario: %s", nombreProducto, nombreUsuario, comentarioDTO.getComentario());

        emailServicio.enviarEmail(new EmailDTO("Nuevo comentario en tu producto", cuerpoMensaje, emailVendedor));

        // Guardar el comentario en la base de datos y devolver su ID
        return comentarioRepo.save(comentario).getIdComentario();
    }


    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(int idProducto) throws Exception {
        List<Comentario> lista = comentarioRepo.listaComentarios(idProducto);

        if(lista.isEmpty()){
            throw new ComentaiosVaciosException("No hay comentarios para este producto");
        }

        List<ComentarioGetDTO> comentario = new ArrayList<>();

        for (Comentario c : lista){
            comentario.add(convertir(c));
        }

        return comentario;
    }


    // Método auxiliar para convertir un objeto de tipo Comentario a ComentarioGetDTO
    private ComentarioGetDTO convertir(Comentario comentario) {

        ComentarioGetDTO comentarioDTO = new ComentarioGetDTO();
        comentarioDTO.setIdComentario(comentario.getIdComentario());
        comentarioDTO.setComentario(comentario.getComentario());
        comentarioDTO.setFechaComentario(comentario.getFechaComentario());
        comentarioDTO.setIdProducto(comentario.getProducto().getIdProducto());
        comentarioDTO.setIdUsuario(comentario.getUsuario().getIdPersona());

        return comentarioDTO;
    }

}
