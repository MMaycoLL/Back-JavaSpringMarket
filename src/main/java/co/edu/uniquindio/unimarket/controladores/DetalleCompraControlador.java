package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detalleCompra")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class DetalleCompraControlador {

    private final DetalleCompraServicio detalleCompraServicio;

    @Operation(summary = "Crear detalle de compra",
            description = "Crea un nuevo detalle de compra con la información proporcionada, incluyendo id de producto, cantidad y precio. Esta capturada en el DTO.")
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearDetalleCompra(@Valid @RequestBody DetalleCompraDTO detalleCompraDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        detalleCompraServicio.crearDetalleCompra(detalleCompraDTO)));
    }

    @Operation(summary = "obtener detalle de compra",
            description = "Obtiene el detalle de compra correspondiente al id especificado.")
    @GetMapping("/obtener/{idDetalleCompra}")
    public ResponseEntity<MensajeDTO> obtenerDetalleCompra(@PathVariable int idDetalleCompra) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        detalleCompraServicio.obtenerDetalleCompra(idDetalleCompra)));
    }
}
