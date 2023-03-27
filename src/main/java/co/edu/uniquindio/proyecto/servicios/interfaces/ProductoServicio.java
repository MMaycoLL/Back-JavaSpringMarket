package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.EstadoAutorizacion;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    int eliminarProducto(int idProducto)throws Exception;

    int actualizarProducto(int idProducto, ProductoDTO productoDTO)throws Exception;

    int actualizarPorEstado(int idProducto, EstadoAutorizacion estadoAutorizacion)throws Exception;

    int actualizarPorUnidades(int idProducto, int unidadesDisponibles) throws Exception;

    ProductoGetDTO obtenerProducto(int idProducto)throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(int idUsuario)throws Exception;

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria)throws Exception;

    List<ProductoGetDTO> listarProductosEstado(EstadoAutorizacion estadoAutorizacion) throws Exception;

    List<ProductoGetDTO> listarProductosNombre(String nombreProducto);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

    List<ProductoGetDTO> listarFavoritosUsuarios(int idUsuario) throws Exception;

}
