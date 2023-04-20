package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productoModerador")
@AllArgsConstructor
public class ProductoModeradorControlador {

    private final ProductoModeradorServicio productoModeradorServicio;

    @PutMapping("/aprobar")
    public ResponseEntity<MensajeDTO> aprobarProducto(@Valid @RequestBody ProductoModeradorDTO productoModeradorDTO) throws Exception {
        productoModeradorServicio.aprobarProducto(productoModeradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        true, "Producto aprobado exitosamente"));
    }

    @PutMapping("/rechazar")
    public ResponseEntity<MensajeDTO> rechazarProducto(@Valid @RequestBody ProductoModeradorDTO productoModeradorDTO) throws Exception {
        productoModeradorServicio.rechazarProducto(productoModeradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        true, "Producto rechazado exitosamente"));
    }

}
