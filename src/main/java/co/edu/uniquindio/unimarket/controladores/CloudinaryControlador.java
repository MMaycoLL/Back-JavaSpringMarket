package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/api/imagenes")
@AllArgsConstructor
public class CloudinaryControlador {

    private final CloudinaryServicio cloudinaryServicio;


    @PostMapping("/subir")
    public ResponseEntity<MensajeDTO> subirImagen(@RequestParam("file") MultipartFile file) throws Exception {
        File imagen = cloudinaryServicio.convertir(file);
        Map respuesta = cloudinaryServicio.subirImagen(imagen, "unimarket");
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        respuesta));
    }

    @DeleteMapping("/eliminar/{idImagen}")
    public ResponseEntity<MensajeDTO> eliminarImagen(@PathVariable String idImagen) throws Exception {
        Map respuesta = cloudinaryServicio.eliminarImagen(idImagen);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MensajeDTO(HttpStatus.OK,
                        false,
                        respuesta));
    }


}
