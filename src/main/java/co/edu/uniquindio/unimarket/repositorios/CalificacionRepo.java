package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepo extends JpaRepository<Calificacion, Integer> {

    // promedio de calificaciones de un producto
    @Query("SELECT AVG(c.valorCalificacion) FROM Calificacion c WHERE c.detalleCompra.producto.idProducto = ?1")
    int promedioCalificacion(int idProducto);

}

