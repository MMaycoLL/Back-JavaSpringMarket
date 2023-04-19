package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productoModerador")
@AllArgsConstructor
public class ProductoModeradorControlador {

    private final ProductoModeradorServicio productoModeradorServicio;
}
