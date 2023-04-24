package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productoModerador")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class ProductoModeradorControlador {

    private final ProductoModeradorServicio productoModeradorServicio;
    private final ProductoServicio productoServicio;

    @Operation(summary = "Aprobar un producto",
            description = "Aprueba un producto existente para que sea visible para los usuarios finales. Se espera un objeto 'productoModeradorDTO' y se requiere autenticación y permisos de moderador.")
    @PutMapping("/aprobar")
    public ResponseEntity<MensajeDTO> aprobarProducto(@Valid @RequestBody ProductoModeradorDTO productoModeradorDTO) throws Exception {
        productoModeradorServicio.aprobarProducto(productoModeradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        true, "Producto aprobado exitosamente"));
    }

    @Operation(summary = "Rechazar un producto",
            description = "Rechaza un producto existente para que no sea visible para los usuarios finales. Se espera un objeto 'productoModeradorDTO' y se requiere autenticación y permisos de moderador.")
    @PutMapping("/rechazar")
    public ResponseEntity<MensajeDTO> rechazarProducto(@Valid @RequestBody ProductoModeradorDTO productoModeradorDTO) throws Exception {
        productoModeradorServicio.rechazarProducto(productoModeradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        true, "Producto rechazado exitosamente"));
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

}
