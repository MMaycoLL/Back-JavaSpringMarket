package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producto")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    @Operation(summary = "Crear un producto",
            description = "Se crea un nuevo producto con la información especificada.")
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        productoServicio.crearProducto(productoDTO)));

    }

    @Operation(summary = "Eliminar un producto",
            description = "Se elimina la información del producto correspondiente al código o Id de producto especificado.")
    @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable int idProducto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(
                        HttpStatus.OK,
                        false,
                        productoServicio.eliminarProducto(idProducto)));

    }

    @Operation(summary = "Actualizar un  producto",
            description = "Se actualiza la información del producto correspondiente al código o Id de producto especificado.")
    @PutMapping("/actualizar/{idProducto}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int idProducto, @Valid @RequestBody ProductoDTO productoDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.actualizarProducto(idProducto, productoDTO)));
    }

    @Operation(summary = "Actualizar estado de un producto",
            description = "Se actualiza el estado del producto correspondiente al código o Id de producto especificado.")
    @PutMapping("/actualizarEstado/{idProducto}/{estadoAutorizacion}")
    public ResponseEntity<MensajeDTO> actualizarPorEstado(@PathVariable int idProducto, @PathVariable EstadoProducto estadoAutorizacion) throws Exception {
        productoServicio.actualizarPorEstado(idProducto, estadoAutorizacion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                new MensajeDTO(HttpStatus.NO_CONTENT,
                        false,
                        "Actualizado correctamente"));
    }

    @Operation(summary = "Actualizar unidades de un producto",
            description = "Se actualiza las unidades disponibles del producto correspondiente al código o Id de producto especificado.")
    @PutMapping("/actualizarUnidades/{idProducto}/{unidadesDisponibles}")
    public ResponseEntity<MensajeDTO> actualizarPorUnidades(@PathVariable int idProducto, @PathVariable int unidadesDisponibles) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.actualizarPorUnidades(idProducto, unidadesDisponibles)));
    }

    @Operation(summary = "Obtener producto",
            description = "Se obtiene la información del producto correspondiente al código o Id de producto especificado.")
    @GetMapping("/obtener/{idProducto}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable int idProducto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.obtenerProducto(idProducto)));
    }

    @Operation(summary = "Listar productos de un usuario",
            description = "Se obtiene la información de los productos correspondientes al código o Id de usuario especificado.")
    @GetMapping("/listarUsuario/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarProductoUsuario(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosUsuario(idUsuario)));
    }

    @Operation(summary = "Listar productos por categoria",
            description = "Se obtiene la información de los productos correspondientes a la categoría especificada.")
    @GetMapping("/listarCategoria/{categoria}")
    public ResponseEntity<MensajeDTO> listarProductoCategoria(@PathVariable Categoria categoria) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosCategoria(categoria)));
    }

    @Operation(summary = "Listar productos por estado",
            description = "Se obtiene la información de los productos correspondientes al estado especificado.")
    @GetMapping("/listarEstado/{estadoAutorizacion}")
    public ResponseEntity<MensajeDTO> listarProductoEstado(@PathVariable EstadoProducto estadoAutorizacion) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosEstado(estadoAutorizacion)));

    }

    @Operation(summary = "Listar productos favoritos de un usuario",
            description = "Se obtiene la información de los productos favoritos correspondientes al código o Id de usuario especificado.")
    @GetMapping("/listarFavoritos/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarFavoritosUsuarios(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarFavoritosUsuarios(idUsuario)));
    }

    @Operation(summary = "Listar productos por nombre",
            description = "Se obtiene la información de los productos correspondientes al nombre especificado.")
    @GetMapping("/listarNombre/{nombre}")
    public ResponseEntity<MensajeDTO> listarProductosNombre(@PathVariable String nombre) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosNombre(nombre)));

    }

    @Operation(summary = "Listar productos por precio",
            description = "Se obtiene la información de los productos correspondientes al rango de precios especificado.")
    @GetMapping("/listarPrecio/{precioMinimo}/{precioMaximo}")
    public ResponseEntity<MensajeDTO> listarProductosPrecio(@PathVariable float precioMinimo, @PathVariable float precioMaximo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosPrecio(precioMinimo, precioMaximo)));

    }

    @Operation(summary = "Listar productos favoritos de un usuario",
            description = "Se obtiene la información de los productos favoritos correspondientes al código o Id de usuario especificado.")
    @GetMapping("/listarFavoritosUsuario/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarFavoritosUsuario(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        productoServicio.listarProductosUsuario(idUsuario)));

    }
}
