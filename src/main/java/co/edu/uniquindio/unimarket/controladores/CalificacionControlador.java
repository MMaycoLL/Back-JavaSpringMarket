package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificacion")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class CalificacionControlador {

    private final CalificacionServicio calificacionServicio;

    @Operation(summary = "Crear una calificación",
            description = "Se crea una calificación con la información del DTO.")
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCalificacion(@Valid @RequestBody CalificacionDTO calificacionDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        calificacionServicio.crearCalificacion(calificacionDTO)));
    }

    @Operation(summary = "Mostrar el promedio de las calificaiones de un producto",
            description = "Se muestra el promedio de las calificaciones del producto con el id especificado.")
    @GetMapping("/promedio/{idProducto}")
    public ResponseEntity<MensajeDTO> promedioCalificacion(@PathVariable int idProducto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        calificacionServicio.promedioCalificacion(idProducto)));
    }

}
