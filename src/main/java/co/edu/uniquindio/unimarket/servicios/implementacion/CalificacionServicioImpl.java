package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.calificacion.PermisoDenegadoCalificacionException;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalificacionServicioImpl implements CalificacionServicio {

    private final CalificacionRepo calificacionRepo;

    private final UsuarioServicio usuarioServicio;

    private final DetalleCompraServicio detalleCompraServicio;

    @Override
    public int crearCalificacion(CalificacionDTO calificacionDTO) throws Exception {

        Usuario usuario = usuarioServicio.obtener(calificacionDTO.getIdUsuario());
        DetalleCompra detalleCompra = detalleCompraServicio.obtener(calificacionDTO.getIdDetalleCompra());

        if (!detalleCompra.getCompra().getUsuario().equals(usuario)) {
            throw new PermisoDenegadoCalificacionException("Usted no tiene el permiso para calificar la compra");
        }

        Calificacion calificacion = new Calificacion();
        calificacion.setValorCalificacion(calificacionDTO.getValorCalificaion());
        calificacion.setComentarioCalificacion(calificacionDTO.getComentarioCalificacion());
        calificacion.setUsuario(usuario);
        calificacion.setDetalleCompra(detalleCompra);

        return calificacionRepo.save(calificacion).getIdCalificacion();
    }


    @Override
    public float promedioCalificacion(int idProducto) {


        return calificacionRepo.promedioCalificacion(idProducto);
    }
}
