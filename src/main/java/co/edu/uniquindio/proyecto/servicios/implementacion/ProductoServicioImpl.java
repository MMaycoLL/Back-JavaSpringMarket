package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.EstadoAutorizacion;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombreProducto(productoDTO.getNombreProducto());
        producto.setDescripcionProducto(productoDTO.getDescripcionProducto());
        producto.setUnidadesDisponibles(productoDTO.getUnidadesDisponibles());
        producto.setPrecioActual(productoDTO.getPrecioActual());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getIdPersona()));
        producto.setImagen(productoDTO.getImagenes());
        producto.setCategorias(productoDTO.getCategorias());
        producto.setACTIVO(true);
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaLimite(LocalDateTime.now().plusDays(60));

        return productoRepo.save(producto).getIdProducto();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {
        return 0;
    }

    @Override
    public int actualizarPorUnidades(int idProducto, int unidadesDisponibles) throws Exception {
        return 0;
    }

    @Override
    public int actualizarPorEstado(int idProducto, EstadoAutorizacion estadoAutorizacion) throws Exception {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int idUsuario) throws Exception {

        List<Producto> lista = productoRepo.listarProductosUsuario(idUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }



    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {

        List<Producto> lista = productoRepo.listarProductosCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(EstadoAutorizacion estadoAutorizacion) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarFavoritosUsuarios(int idUsuario) throws Exception {
        // listar productos favoritos de un usuario


        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {

        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {

        List<Producto> lista = productoRepo.listarProductosPrecio(precioMinimo, precioMaximo);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    private ProductoGetDTO convertir(Producto producto) {

        ProductoGetDTO productoDTO = new ProductoGetDTO(
                producto.getIdProducto(),
                producto.isACTIVO(),
                producto.getFechaLimite(),
                producto.getNombreProducto(),
                producto.getDescripcionProducto(),
                producto.getUnidadesDisponibles(),
                producto.getPrecioActual(),
                producto.getUsuario().getIdPersona(),
                producto.getImagen(),
                producto.getCategorias()

        );

        return productoDTO;
    }
}
