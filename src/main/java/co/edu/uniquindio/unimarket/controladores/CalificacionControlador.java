package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificacion")
@AllArgsConstructor
public class CalificacionControlador {

    private final CalificacionServicio calificacionServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCalificacion(@Valid @RequestBody CalificacionDTO calificacionDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        calificacionServicio.crearCalificacion(calificacionDTO)));
    }

    @GetMapping("/promedio/{idProducto}")
    public ResponseEntity<MensajeDTO> promedioCalificacion(@PathVariable int idProducto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        calificacionServicio.promedioCalificacion(idProducto)));
        }

}
