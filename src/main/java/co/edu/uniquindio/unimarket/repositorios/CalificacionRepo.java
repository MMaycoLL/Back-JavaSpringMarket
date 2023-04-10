package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepo extends JpaRepository<Calificacion, Integer> {
    @Query("SELECT AVG(pc.calificacion) FROM DetalleCompra pc WHERE pc.producto.idProducto = :idProducto")
    Float obtenerPromedioCalificacionesPorProducto( int idProducto);

    @Query("SELECT pc FROM DetalleCompra pc WHERE pc.producto.idProducto = :idProducto")
    List<DetalleCompra> findByProductoId(int idProducto);
}

