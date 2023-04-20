package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comentario")
@AllArgsConstructor
public class ComentarioControlador {


    private final ComentarioServicio comentarioServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        comentarioServicio.crearComentario(comentarioDTO)));
    }

    @GetMapping("/listar/{idProducto}")
    public ResponseEntity<MensajeDTO> listarComentariosProducto(@PathVariable int idProducto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        comentarioServicio.listarComentariosProducto(idProducto)));
    }

}
