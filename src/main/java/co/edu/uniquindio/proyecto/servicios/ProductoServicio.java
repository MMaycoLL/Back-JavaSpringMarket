package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.EstadoAutorizacion;

import java.util.List;

public interface ProductoServicio {

    int crearProducto( ProductoDTO productoDTO);

    int eliminarProducto(int idProducto);

    int actualizarProducto(int idProducto, ProductoDTO productoDTO);

    int actualizarPorEstado(int idProducto, EstadoAutorizacion estadoAutorizacion);

    int actualizarPorUnidades(int idProducto, int unidadesDisponibles);

    ProductoGetDTO obtenerProducto(int idProducto);

    List< ProductoGetDTO> listarProductosUsuario(int idUsuario);

    List< ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List< ProductoGetDTO>listarProductosEstado(EstadoAutorizacion estadoAutorizacion);

    List< ProductoGetDTO>listarProductosNombre(String nombreProducto);

    List< ProductoGetDTO>listarProductosPrecio(float precioMinimo, float precioMaximo);

    List< ProductoGetDTO>listarFavoritosUsuarios(int idUsuario);

}
