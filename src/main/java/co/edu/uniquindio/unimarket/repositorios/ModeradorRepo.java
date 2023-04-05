package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Moderador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {
    Optional<Moderador> findByEmail(String email);
}
