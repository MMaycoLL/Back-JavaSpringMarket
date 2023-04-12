package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {


        // Verificar que la descripción del producto no exceda un número máximo de caracteres permitidos
        if (productoDTO.getDescripcionProducto() != null && productoDTO.getDescripcionProducto().length() > 1000) {
            throw new Exception("La descripción del producto no debe exceder los 1000 caracteres.");
        }

        // Verificar que el nombre del producto no exceda un número máximo de caracteres permitidos
        if (productoDTO.getNombreProducto() != null && productoDTO.getNombreProducto().length() > 100) {
            throw new Exception("El nombre del producto no debe exceder los 100 caracteres.");
        }

        Producto producto = convertir(productoDTO);

        return productoRepo.save(producto).getIdProducto();
    }

    @Override
    public ProductoGetDTO actualizarProducto(int idProducto, ProductoDTO productoDTO) throws Exception {

        validarExistenciaProducto(idProducto);

        Producto producto = convertir(productoDTO);
        producto.setIdProducto(idProducto);

        return convertir(productoRepo.save(producto));
    }

    @Override
    public int actualizarPorUnidades(int idProducto, int unidadesDisponibles) throws Exception {
        return 0;
    }

    @Override
    public int actualizarPorEstado(int idProducto, EstadoProducto estadoAutorizacion) throws Exception {
        Producto producto = obtener(idProducto);
        producto.setEstadoProducto(estadoAutorizacion);
        return productoRepo.save(producto).getIdProducto();
    }

    @Override
    public int eliminarProducto(int idProducto) throws Exception {
        validarExistenciaProducto(idProducto);
        productoRepo.deleteById(idProducto);
        return idProducto;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int idProducto) throws Exception {
        return convertir(obtener(idProducto));
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
        List<Producto> lista = productoRepo.listarProductosPorCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }


    @Override
    public List<ProductoGetDTO> listarProductosEstado(EstadoProducto estadoAutorizacion) throws Exception {

        List<Producto> lista = productoRepo.listarProductosEstado(estadoAutorizacion);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarFavoritosUsuarios(int idUsuario) throws Exception {

        List<Producto> lista = productoRepo.listarFavoritosUsuarios(idUsuario);

        if (lista.isEmpty()) {
            throw new Exception("El usuario no tiene productos favoritos");
        }

        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
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

    public Producto obtener(int idProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(idProducto);

        if (producto.isEmpty()) {
            throw new Exception("El código " + idProducto + " no está asociado a ningún producto");
        }
        return producto.get();
    }

    private void validarExistenciaProducto(int idProducto) throws Exception {
        boolean existe = productoRepo.existsById(idProducto);

        if (!existe) {
            throw new Exception("El código1 " + idProducto + " no está asociado a ningún producto");
        }

    }

    private ProductoGetDTO convertir(Producto producto) {

        ProductoGetDTO productoDTO = new ProductoGetDTO(
                producto.getIdProducto(),
                producto.getEstadoProducto(),
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

    private Producto convertir(ProductoDTO productoDTO) throws Exception {
        Producto producto = new Producto();
        producto.setNombreProducto(productoDTO.getNombreProducto());
        producto.setDescripcionProducto(productoDTO.getDescripcionProducto());
        producto.setUnidadesDisponibles(productoDTO.getUnidadesDisponibles());
        producto.setPrecioActual(productoDTO.getPrecioActual());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getIdPersona()));
        producto.setImagen(productoDTO.getImagenes());
        producto.setCategorias(productoDTO.getCategorias());
        producto.setEstadoProducto(EstadoProducto.SIN_REVISAR);
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaLimite(LocalDateTime.now().plusDays(60));

        return producto;
    }


}
