package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.ProductoModerador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoModeradorRepo extends JpaRepository<ProductoModerador, Integer> {

    @Query("SELECT pm FROM ProductoModerador pm WHERE pm.producto.idProducto = :idProducto")
    ProductoModerador findByProductoId(int idProducto);



}
