package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalleCompra")
@AllArgsConstructor
public class DetalleCompraControlador {

    private final DetalleCompraServicio detalleCompraServicio;

    public DetalleCompra crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception {
        return null;
    }

    public DetalleCompraGetDTO obtenerDetalleCompra(int idDetalleCompra) throws Exception {
        return null;
    }
}
