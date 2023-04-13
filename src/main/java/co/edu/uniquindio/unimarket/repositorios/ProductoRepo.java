package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    // listar productos por usuario
    @Query("select p from Producto p where p.usuario.idPersona = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);


    // listar productos por nombre
    @Query("select p from Producto p where p.nombreProducto like concat( '%', :nombre, '%') and p.estadoProducto <> 'INACTIVO'")
    List<Producto> listarProductosNombre(String nombre);


    // listar productos por categoria

    @Query("select p from Producto p where :categoria member of p.categorias and p.fechaLimite > CURRENT_DATE() and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto.ACTIVO")
    List<Producto> listarProductosCategoria(Categoria categoria);


    // listar productos por estado moderador
    @Query("select p from ProductoModerador pm join pm.producto p where pm.estadoAutorizacion = :estadoAutorizacion")
    List<Producto> listarProductosEstado(EstadoProducto estadoAutorizacion);


    // listar productos por precio minimo y maximo
    @Query("select p from Producto p where p.precioActual between :precioMinimo and :precioMaximo and p.fechaLimite > CURRENT_DATE() and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto.ACTIVO")
    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);


    // Listar favoritos de un usuario
    @Query("SELECT f.producto FROM Favorito f WHERE f.usuario.idPersona = :idUsuario  and f.producto.fechaLimite > CURRENT_DATE() and f.producto.estadoProducto = co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto.ACTIVO")
    List<Producto> listarFavoritosUsuarios(int idUsuario);


}
