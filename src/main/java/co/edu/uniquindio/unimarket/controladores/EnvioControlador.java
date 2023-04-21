package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envio")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class EnvioControlador {

    private final EnvioServicio envioServicio;

    @Operation(summary = "Crear un envío",
            description = "Se crea un envío con el ID de usuario y el respectivo DTO.")
    @PostMapping("/crear/{idUsuario}")
    public ResponseEntity<MensajeDTO> crearEnvio(@Valid @RequestBody EnvioDTO envioDTO, @PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(HttpStatus.CREATED,
                        false,
                        envioServicio.crearEnvio(envioDTO, idUsuario)));
    }

    @Operation(summary = "Actualizar un envío",
            description = "Se actualiza un envío con la información especificada, id de envio y respectivo DTO.")
    @PutMapping("actualizar/{idEnvio}")
    public ResponseEntity<MensajeDTO> actualizarEnvio(@PathVariable int idEnvio, @Valid @RequestBody EnvioDTO envioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        envioServicio.actualizarEnvio(idEnvio, envioDTO)));
    }

    @Operation(summary = "Eliminar un envío",
            description = "Se elimina un envío con el id de envío especificado.")
    @DeleteMapping("/eliminar/{idEnvio}")
    public ResponseEntity<MensajeDTO> eliminarEnvio(@PathVariable int idEnvio) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        envioServicio.eliminarEnvio(idEnvio)));
    }

    @Operation(summary = "Obtener un envío",
            description = "Se obtiene un envío con el id de envío especificado.")
    @GetMapping("/obtener/{idEnvio}")
    public ResponseEntity<MensajeDTO> obtenerEnvio(@PathVariable int idEnvio) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        envioServicio.obtenerEnvio(idEnvio)));
    }


}
