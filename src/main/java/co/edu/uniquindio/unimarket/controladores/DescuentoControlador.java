package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/descuento")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class DescuentoControlador {

    private final DescuentoServicio descuentoServicio;

    @Operation(summary = "Aplicar un descuento",
            description = "Se aplica el descuento correspondiente a la información del descuento especificado en el DTO.")
    @PutMapping("/aplicarDCTO")
    public ResponseEntity<MensajeDTO> aplicarDescuento(@Valid @RequestBody DescuentoDTO descuentoDTO) throws Exception {
        descuentoServicio.aplicarDescuento(descuentoDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                new MensajeDTO(
                        HttpStatus.NO_CONTENT,
                        false,
                        "Descuento aplicado"));
    }

}
