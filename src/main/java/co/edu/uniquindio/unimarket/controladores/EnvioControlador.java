package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.EnvioGetDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envio")
@AllArgsConstructor
public class EnvioControlador {

    private final EnvioServicio envioServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearEnvio(@Valid @RequestBody EnvioDTO envioDTO, @PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(HttpStatus.CREATED,
                        false,
                        envioServicio.crearEnvio(envioDTO, idUsuario)));
    }

    @PutMapping("actualizar/{idEnvio}")
    public ResponseEntity<MensajeDTO> actualizarEnvio(@PathVariable int idEnvio,@Valid @RequestBody EnvioDTO envioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        envioServicio.actualizarEnvio(idEnvio, envioDTO)));
    }

    @DeleteMapping("/eliminar/{idEnvio}")
    public ResponseEntity<MensajeDTO>  eliminarEnvio(@PathVariable int idEnvio) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        envioServicio.eliminarEnvio(idEnvio)));
    }

    @GetMapping("/obtener/{idEnvio}")
    public ResponseEntity<MensajeDTO> obtenerEnvio(@PathVariable int idEnvio) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        envioServicio.obtenerEnvio(idEnvio)));
    }


}
