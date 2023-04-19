package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productoModerador")
@AllArgsConstructor
public class ProductoModeradorControlador {

    private final ProductoModeradorServicio productoModeradorServicio;

    public void aprobarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
    }

    public void rechazarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception {
    }

}
