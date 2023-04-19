package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;

}
