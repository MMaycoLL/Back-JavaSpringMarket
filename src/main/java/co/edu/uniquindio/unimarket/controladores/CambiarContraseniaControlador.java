package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.RecuperarContraseniaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cambiarContrasenia")
@AllArgsConstructor
public class CambiarContraseniaControlador {

    private final RecuperarContraseniaServicio recuperarContraseniaServicio;

    @Operation(summary = "Enviar link para cambiar la contraseña",
            description = "Se envia un link al correo del usuario para cambiar la contraseña.")
    @PutMapping("/link/{email}")
    public ResponseEntity<MensajeDTO> linkCambiarContrasenia(@PathVariable String email) throws Exception {
        recuperarContraseniaServicio.linkCambiarContrasenia(email);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false, "Se ha enviado un correo con el link para cambiar la contraseña"));
    }


    @Operation(summary = "Cambiar la contraseña",
            description = "Se cambia la contraseña del usuario.")
    @PutMapping("/cambiar/{email}/{cedula}/{contrasenia}")
    public ResponseEntity<MensajeDTO> cambiarContrasenia(@PathVariable String email,@PathVariable String cedula, @PathVariable String contrasenia) throws Exception {
        recuperarContraseniaServicio.cambiarContrasenia(email,cedula, contrasenia);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false, "Se ha cambiado la contraseña con exito"));

    }
}
