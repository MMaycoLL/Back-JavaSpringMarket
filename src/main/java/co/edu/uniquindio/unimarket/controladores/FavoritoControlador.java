package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favoritos")
@AllArgsConstructor
public class FavoritoControlador {

    private final FavoritoServicio favoritoServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearFavorito(@Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception {
        favoritoServicio.crearFavorito(favoritoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        true,
                        "Favorito creado exitosamente"));
    }

    @DeleteMapping("/eliminar/{idUsuario}/{idProducto}")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@PathVariable int idUsuario, @PathVariable int idProducto) throws Exception {
        favoritoServicio.eliminarFavorito(idUsuario, idProducto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(
                        HttpStatus.OK,
                        false, "Favorito eliminado exitosamente"));

    }

}
