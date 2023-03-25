package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.EstadoAutorizacion;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {


    private final ProductoRepo productoRepo; // siempre final y @AllArgsConstructor

    @Override
    public int crearProducto(ProductoDTO productoDTO) {
        return 0;


    }

    @Override
    public int eliminarProducto(int idProducto) {
        return 0;
    }

    @Override
    public int actualizarProducto(int idProducto, ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int actualizarPorEstado(int idProducto, EstadoAutorizacion estadoAutorizacion) {
        return 0;
    }

    @Override
    public int actualizarPorUnidades(int idProducto, int unidadesDisponibles) {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int idProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int idUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(EstadoAutorizacion estadoAutorizacion) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombreProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarFavoritosUsuarios(int idUsuario) {
        return null;
    }
}
