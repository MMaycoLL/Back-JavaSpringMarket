package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DescuentoRepo extends JpaRepository<Descuento, Integer> {

    @Query("SELECT d FROM Descuento d WHERE d.producto.idProducto = :idProducto AND d.fechaInicioDescuento <= :fechaActual AND d.fechaFinalDescuento >= :fechaActual")
    List<Descuento> buscarDescuentosAplicables(@Param("idProducto") int idProducto, @Param("fechaActual") LocalDate fechaActual);

}
