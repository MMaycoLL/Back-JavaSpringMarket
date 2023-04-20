package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCompra(CompraDTO compraDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        false,
                        compraServicio.crearCompra(compraDTO)));
    }

    @GetMapping("/listar/{idUsuario}")
    public ResponseEntity<MensajeDTO> listarComprasUsuarios(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        compraServicio.listarComprasUsuarios(idUsuario)));
    }

    @GetMapping("/obtener/{idCompra}")
    public ResponseEntity<MensajeDTO> obtenerCompra(@PathVariable int idCompra) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        compraServicio.obtenerCompra(idCompra)));
    }


}
