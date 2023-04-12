package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalificacionServicioImpl implements CalificacionServicio {

    private final CalificacionRepo calificacionRepo;

    private final DetalleCompraRepo detalleCompraRepo;

    private final CompraRepo compraRepo;

    private final ProductoRepo productoRepo;

    @Override
    public int crearCalificacion(CalificacionDTO calificacionDTO) throws Exception {
        return 0;
    }




    @Override
    public int promedioCalificacion(int idProducto) {
       // return calificacionRepo.promedioCalificacion(idProducto);
return 0;
    }
}
