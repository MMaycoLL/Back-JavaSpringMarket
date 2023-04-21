package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favoritos")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class FavoritoControlador {

    private final FavoritoServicio favoritoServicio;

    @Operation(summary = "Crear un favorito",
            description = "Se crea un favorito con la información del usuario y el producto correspondiente contenida en el DTO.")
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearFavorito(@Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception {
        favoritoServicio.crearFavorito(favoritoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new MensajeDTO(
                        HttpStatus.CREATED,
                        true,
                        "Favorito creado exitosamente"));
    }

    @Operation(summary = "Eliminar un favorito",
            description = "Se elimina el favorito correspondiente al id del usuario y el id del producto especificados.")
    @DeleteMapping("/eliminar/{idUsuario}/{idProducto}")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@PathVariable int idUsuario, @PathVariable int idProducto) throws Exception {
        favoritoServicio.eliminarFavorito(idUsuario, idProducto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(
                        HttpStatus.OK,
                        false, "Favorito eliminado exitosamente"));

    }

}
