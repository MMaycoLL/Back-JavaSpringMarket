package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calificacion")
@AllArgsConstructor
public class CalificacionControlador {

    private final CalificacionServicio calificacionServicio;

}
