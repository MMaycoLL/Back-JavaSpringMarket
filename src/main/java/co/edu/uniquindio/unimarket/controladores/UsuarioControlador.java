package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;



    @PutMapping("/actualizar/{idUsuario}")
    public ResponseEntity<MensajeDTO>  actualizarUsuario(@PathVariable int idUsuario, @Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        usuarioServicio.actualizarUsuario(idUsuario, usuarioDTO)));
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable  int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(
                        HttpStatus.OK,
                        false,
                        usuarioServicio.eliminarUsuario(idUsuario)));
    }

    @GetMapping("/obteber/{idUsuario}")
    public ResponseEntity<MensajeDTO>  obtenerUsuario(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        usuarioServicio.obtenerUsuario(idUsuario)));
    }
}
