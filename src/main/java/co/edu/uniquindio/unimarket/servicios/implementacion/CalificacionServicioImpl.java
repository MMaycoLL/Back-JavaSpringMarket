package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.ProductoCompra;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoCompraRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalificacionServicioImpl implements CalificacionServicio {

    private final CalificacionRepo calificacionRepo;

    private final ProductoCompraRepo productoCompraRepo;

    private final CompraRepo compraRepo;

    private final ProductoRepo productoRepo;

    @Override
    public int crearCalificacion(CalificacionDTO calificacionDTO) throws Exception {

        // Obtener el usuario de la compra
        Usuario usuario = compraRepo.findUsuarioByIdCompra(calificacionDTO.getIdProductoCompra());

        // Verificar si el usuario es nulo
        if (usuario == null) {
            throw new Exception("No se pudo encontrar el usuario de la compra");
        }

        // Obtener el producto de la compra
        Producto producto = productoRepo.findProductoByIdCompra(calificacionDTO.getIdProductoCompra());

        // Verificar si el producto es nulo
        if (producto == null) {
            throw new Exception("No se pudo encontrar el producto de la compra");
        }

        Calificacion calificacion = new Calificacion();
        calificacion.setValorCalificacion(calificacionDTO.getValorCalificaion());
        calificacion.setComentarioCalificacion(calificacionDTO.getComentarioCalificacion());
        calificacion.setUsuario(usuario);

        ProductoCompra productoCompra = productoCompraRepo.findById(calificacionDTO.getIdProductoCompra())
                .orElseThrow(() -> new Exception("No se pudo encontrar el productoCompra"));

        productoCompra.setProducto(producto);
        calificacion.setProductoCompra(productoCompra);

        return calificacionRepo.save(calificacion).getIdCalificacion();
    }




    @Override
    public int promedioCalificacion(int idProducto) {
       // return calificacionRepo.promedioCalificacion(idProducto);
return 0;
    }
}
