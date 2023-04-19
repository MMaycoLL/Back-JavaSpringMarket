package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalleCompra")
@AllArgsConstructor
public class DetalleCompraControlador {

    private final DetalleCompraServicio detalleCompraServicio;

}
