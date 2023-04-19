package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cloudinary")
@AllArgsConstructor
public class CloudinaryControlador {

    private final CloudinaryServicio cloudinaryServicio;

}
