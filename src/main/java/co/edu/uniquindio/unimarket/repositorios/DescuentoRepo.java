package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DescuentoRepo extends JpaRepository<Descuento, Integer> {

    @Query("SELECT d, p FROM Descuento d JOIN d.producto p WHERE d.fechaFinalDescuento >= :fechaActual")
    List<Object[]> findDescuentosVigentes(LocalDate fechaActual);

}
