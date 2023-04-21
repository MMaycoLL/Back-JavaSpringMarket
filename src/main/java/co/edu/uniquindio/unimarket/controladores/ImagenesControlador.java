package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/api/imagenes")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class ImagenesControlador {

    private final CloudinaryServicio cloudinaryServicio;


    @Operation(summary = "Subir una imagen a cloudinary",
            description = "Se sube una imagen al servidor de cloudinary.")
    @PostMapping("/subir")
    public ResponseEntity<MensajeDTO> subirImagen(@RequestParam("file") MultipartFile file) throws Exception {
        File imagen = cloudinaryServicio.convertir(file);
        Map respuesta = cloudinaryServicio.subirImagen(imagen, "unimarket");
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        respuesta));
    }

    @Operation(summary = "Eliminar una imagen de cloudinary",
            description = "Se elimina una imagen del servidor de cloudinary.")
    @DeleteMapping("/eliminar/{idImagen}")
    public ResponseEntity<MensajeDTO> eliminarImagen(@PathVariable String idImagen) throws Exception {
        Map respuesta = cloudinaryServicio.eliminarImagen(idImagen);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        respuesta));
    }


}
