package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoControlador {

    private final ProductoServicio productoServicio;


    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        productoServicio.crearProducto(productoDTO)));

    }

    @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable int idProducto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(
                        HttpStatus.OK,
                        false,
                        productoServicio.eliminarProducto(idProducto)));

    }

    @PutMapping("/actualizar/{idProducto}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int idProducto, @Valid @RequestBody ProductoDTO productoDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.actualizarProducto(idProducto, productoDTO)));
    }

    @PutMapping("/actualizarEstado/{idProducto}/{estadoAutorizacion}")
    public ResponseEntity<MensajeDTO> actualizarPorEstado(@PathVariable int idProducto, @PathVariable EstadoProducto estadoAutorizacion) throws Exception {
        productoServicio.actualizarPorEstado(idProducto, estadoAutorizacion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                new MensajeDTO(HttpStatus.NO_CONTENT,
                        false,
                        "Actualizado correctamente"));
    }


    @PutMapping("/actualizarUnidades/{idProducto}/{unidadesDisponibles}")
    public ResponseEntity<MensajeDTO> actualizarPorUnidades(@PathVariable int idProducto, @PathVariable int unidadesDisponibles) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.actualizarPorUnidades(idProducto, unidadesDisponibles)));
    }

    @GetMapping("/obtener/{idProducto}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable int idProducto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.obtenerProducto(idProducto)));
    }

    @GetMapping("/listarUsuario/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarProductoUsuario(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosUsuario(idUsuario)));
    }

    @GetMapping("/listarCategoria/{categoria}")
    public ResponseEntity<MensajeDTO> listarProductoCategoria(@PathVariable Categoria categoria) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosCategoria(categoria)));
    }

    @GetMapping("/listarEstado/{estadoAutorizacion}")
    public ResponseEntity<MensajeDTO> listarProductoEstado(@PathVariable EstadoProducto estadoAutorizacion) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosEstado(estadoAutorizacion)));

    }

    @GetMapping("/listarFavoritos/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarFavoritosUsuarios(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarFavoritosUsuarios(idUsuario)));
    }

    @GetMapping("/listarNombre/{nombre}")
    public ResponseEntity<MensajeDTO> listarProductosNombre(@PathVariable String nombre) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosNombre(nombre)));

    }

    @GetMapping("/listarPrecio/{precioMinimo}/{precioMaximo}")
    public ResponseEntity<MensajeDTO> listarProductosPrecio(@PathVariable float precioMinimo, @PathVariable float precioMaximo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosPrecio(precioMinimo, precioMaximo)));

    }

    @GetMapping("/listarFavoritosUsuario/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarFavoritosUsuario(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosUsuario(idUsuario)));

    }
}
