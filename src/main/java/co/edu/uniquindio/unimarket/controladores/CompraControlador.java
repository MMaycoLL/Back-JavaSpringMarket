package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compra")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;

    @Operation(summary = "Crear una compra",
            description = "Crea una nueva compra con la información proporcionada, incluyendo id de usuario, metodo de pago, id de envio y detalle compraDTO. Esta capturada en el DTO.")
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCompra(@RequestBody CompraDTO compraDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        compraServicio.crearCompra(compraDTO)));
    }

    @Operation(summary = "Listar compras de un usuario",
            description = "Lista las compras de un usuario especificado.")
    @GetMapping("/listar/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarComprasUsuarios(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        compraServicio.listarComprasUsuarios(idUsuario)));
    }

    @Operation(summary = "Obtener una compra",
            description = "Obtiene la compra correspondiente al id especificado.")
    @GetMapping("/obtener/{idCompra}")
    public ResponseEntity<MensajeDTO> obtenerCompra(@PathVariable int idCompra) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        compraServicio.obtenerCompra(idCompra)));
    }


}
