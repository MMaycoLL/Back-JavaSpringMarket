package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @Operation(summary = "Actualizar un usuario",
            description = "Se actualiza la información del usuario correspondiente al código o Id de usuario especificado.")
    @PutMapping("/actualizar/{idUsuario}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int idUsuario, @Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        usuarioServicio.actualizarUsuario(idUsuario, usuarioDTO)));
    }

    @Operation(summary = "Eliminar un usuario",
            description = "Se elimina la información del usuario correspondiente al código o Id de usuario especificado.")
    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(
                        HttpStatus.OK,
                        false,
                        usuarioServicio.eliminarUsuario(idUsuario)));
    }

    @Operation(summary = "Obtener un usuario",
            description = "Obtiene la información del usuario correspondiente al código o Id de usuario especificado.")
    @GetMapping("/obtener/{idUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        usuarioServicio.obtenerUsuario(idUsuario)));
    }
}
