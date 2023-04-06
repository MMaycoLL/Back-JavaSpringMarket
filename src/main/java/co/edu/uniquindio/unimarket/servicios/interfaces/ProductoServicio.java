package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoAutorizacion;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    int eliminarProducto(int idProducto)throws Exception;

    ProductoGetDTO actualizarProducto(int idProducto, ProductoDTO productoDTO)throws Exception;

    int actualizarPorEstado(int idProducto, EstadoAutorizacion estadoAutorizacion)throws Exception;

    int actualizarPorUnidades(int idProducto, int unidadesDisponibles) throws Exception;

    ProductoGetDTO obtenerProducto(int idProducto)throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(int idUsuario)throws Exception;

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria)throws Exception;

    List<ProductoGetDTO> listarProductosEstado(EstadoAutorizacion estadoAutorizacion) throws Exception;

    List<ProductoGetDTO> listarProductosNombre(String nombreProducto);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

    List<ProductoGetDTO> listarFavoritosUsuarios(int idUsuario) throws Exception;

    Producto obtener(int idUsuario) throws Exception;




}
