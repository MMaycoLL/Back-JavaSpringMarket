package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Favorito;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavoritoRepo extends JpaRepository<Favorito, Integer> {

    @Query("SELECT f FROM Favorito f WHERE f.usuario = :usuario AND f.producto = :producto")
    Optional<Favorito> findByUsuarioAndProducto( Usuario usuario,  Producto producto);




}
