package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/descuento")
@AllArgsConstructor
public class DescuentoControlador {

    private final DescuentoServicio descuentoServicio;

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
