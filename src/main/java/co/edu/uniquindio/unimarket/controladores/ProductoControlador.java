package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    /*
    A cada método se le debe añadir una anotación de acuerdo al método HTTP que deba dar
respuesta. Para obtener se usa GET, para guardar o registrar se usa POST, para borrar DELETE y
para modificar PUT.
     */

    @PostMapping
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
        return 0;

    }

    @DeleteMapping("/{idProducto}")
    public void eliminarProducto(int idProducto) throws Exception {

    }

    @PutMapping("/{idProducto}")
    public ProductoGetDTO actualizarProducto(int idProducto, ProductoDTO productoDTO) throws Exception {
        return null;
    }

    @PutMapping("/{idProducto, estadoAutorizacion}")
    public void actualizarPorEstado(int idProducto, EstadoProducto estadoAutorizacion) throws Exception {

    }


    @PutMapping("/{idProducto, unidadesDisponibles}")
    public int actualizarPorUnidades(int idProducto, int unidadesDisponibles) throws Exception {
        return 0;
    }

    @GetMapping("/{idProducto}")
    public ProductoGetDTO obtenerProducto(int idProducto) throws Exception {
        return null;

    }


    @GetMapping("{idUsuario}")
    public List<ProductoGetDTO> listarProductoUsuario(int idUsuario) throws Exception {
        return null;
    }

    @GetMapping("{idCategoria}")
    public List<ProductoGetDTO> listarProductoCategoria(int idCategoria) throws Exception {
        return null;
    }

    @GetMapping("{estadoAutorizacion}")
    public List<ProductoGetDTO> listarProductoEstado(EstadoProducto estadoAutorizacion) throws Exception {
        return null;

    }

    @GetMapping("{idUsuario}")
    public List<ProductoGetDTO> listarFavoritosUsuarios(int idUsuario) throws Exception {
        return null;

    }

    @GetMapping("{nombre}")
    public List<ProductoGetDTO> listarProductosNombre(String nombre) throws Exception {
        return null;

    }

    @GetMapping("{precioMinimo, precioMaximo}")
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) throws Exception {
        return null;

    }


    @GetMapping("{idUsuario}")
    public List<ProductoGetDTO> listarFavoritosUsuario(int idUsuario) throws Exception {
        return null;

    }


    @GetMapping("{idProducto}")
    public Producto obtener(int idProducto) throws Exception {
        return null;

    }

}
