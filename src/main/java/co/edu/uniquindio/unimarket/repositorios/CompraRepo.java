package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("SELECT c FROM Compra c WHERE c.usuario.idPersona = :idUsuario")
    List<Compra> findByUsuarioIdUsuario(int idUsuario);

}
