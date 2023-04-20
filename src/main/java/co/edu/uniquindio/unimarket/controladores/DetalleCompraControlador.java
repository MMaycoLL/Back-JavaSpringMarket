package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detalleCompra")
@AllArgsConstructor
public class DetalleCompraControlador {

    private final DetalleCompraServicio detalleCompraServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearDetalleCompra(@Valid @RequestBody DetalleCompraDTO detalleCompraDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        detalleCompraServicio.crearDetalleCompra(detalleCompraDTO)));
    }

    public ResponseEntity<MensajeDTO> obtenerDetalleCompra(@PathVariable int idDetalleCompra) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        detalleCompraServicio.obtenerDetalleCompra(idDetalleCompra)));    }
}
