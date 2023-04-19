package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/cloudinary")
@AllArgsConstructor
public class CloudinaryControlador {

    private final CloudinaryServicio cloudinaryServicio;


    public Map subirImagen(File file, String carpeta) throws Exception {
        return null;
    }

    public Map eliminarImagen(String idImagen) throws Exception {
        return null;
    }

    public File convertir(MultipartFile imagen) throws IOException {
        return null;
    }
}
