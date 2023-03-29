package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.EstadoAutorizacion;
import co.edu.uniquindio.proyecto.entidades.Producto;
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
    @Query("select p from Producto p where p.nombreProducto like concat( '%', :nombre, '%' ) and p.ACTIVO = true")
    List<Producto> listarProductosNombre(String nombre);

    // listar productos por categoria
    @Query("select p from Producto p where p.categorias = :categoria and p.ACTIVO = true")
    List<Producto> listarProductosCategoria(Categoria categoria);

    // listar productos por precio minimo y maximo
    @Query("select p from Producto p where p.precioActual between :precioMinimo and :precioMaximo and p.ACTIVO = true")
    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);

    // listar productos por estado moderador
    @Query("select p from ProductoModerador pm join pm.producto p where pm.estadoAutorizacion = :estadoAutorizacion")
    List<Producto> listarProductosEstado(EstadoAutorizacion estadoAutorizacion);

    // Actualizar unidades de un producto
    @Query("update Producto p set p.unidadesDisponibles = :unidades where p.idProducto = :idProducto")
    void actualizarUnidades(int idProducto, int unidades);


}
