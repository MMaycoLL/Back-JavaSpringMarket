package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/descuento")
@AllArgsConstructor
public class DescuentoControlador {

    private final DescuentoServicio descuentoServicio;


    public void aplicarDescuento(DescuentoDTO descuentoDTO) throws Exception {

    }

}
