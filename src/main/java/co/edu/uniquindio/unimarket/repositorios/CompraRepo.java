package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("SELECT pc.compra.usuario FROM DetalleCompra pc WHERE pc.idProductoCompra = :idProductoCompra")
    Usuario findUsuarioByIdCompra(int idProductoCompra);


}
