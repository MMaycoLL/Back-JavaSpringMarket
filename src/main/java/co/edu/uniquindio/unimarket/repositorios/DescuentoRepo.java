package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DescuentoRepo extends JpaRepository<Descuento, Integer> {

    @Query("SELECT p.fechaLimite FROM Producto p WHERE p.idProducto = :idProducto")
    LocalDate obtenerFechaLimite(int idProducto);

}
