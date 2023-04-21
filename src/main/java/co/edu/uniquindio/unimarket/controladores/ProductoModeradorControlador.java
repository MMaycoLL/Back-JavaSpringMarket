package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productoModerador")
@AllArgsConstructor
public class ProductoModeradorControlador {

    private final ProductoModeradorServicio productoModeradorServicio;

    @PutMapping("/aprobar")
    public ResponseEntity<MensajeDTO> aprobarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
        productoModeradorServicio.aprobarProducto(productoModeradorDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                new MensajeDTO(HttpStatus.NO_CONTENT,
                        false,
                        "Aprobado"));
    }

    @PutMapping("/rechazar")
    public ResponseEntity<MensajeDTO> rechazarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
        productoModeradorServicio.rechazarProducto(productoModeradorDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                new MensajeDTO(HttpStatus.NO_CONTENT,
                        false,
                        "Rechazado"));
    }

}
