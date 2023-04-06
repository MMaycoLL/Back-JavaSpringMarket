package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoAutorizacion;
import co.edu.uniquindio.unimarket.entidades.Producto;
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
    @Query("select p from Producto p join p.categorias c where c = :categoria and p.fechaLimite < CURRENT_DATE() and p.estadoProducto <> 'INACTIVO'")
    List<Producto> listarProductosPorCategoria(Categoria categoria);



    // listar productos por estado moderador
    @Query("select p from ProductoModerador pm join pm.producto p where pm.estadoAutorizacion = :estadoAutorizacion")
    List<Producto> listarProductosEstado(EstadoAutorizacion estadoAutorizacion);


    // listar productos por precio minimo y maximo
    @Query("select p from Producto p where p.precioActual between :precioMinimo and :precioMaximo and p.estadoProducto <> 'INACTIVO'")
    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);


    // Actualizar unidades de un producto
    @Query("update Producto p set p.unidadesDisponibles = :unidades where p.idProducto = :idProducto")
    void actualizarUnidades(int idProducto, int unidades);

    @Query("select p from Producto p where p.fechaLimite < CURRENT_DATE and p.estadoProducto <> 'INACTIVO'")
    List<Producto> listarProductos();

}
