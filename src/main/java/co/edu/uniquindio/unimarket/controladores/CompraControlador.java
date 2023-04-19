package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;


    public int crearCompra(CompraDTO compraDTO) throws Exception {
        return 0;
    }

    public List<CompraGetDTO> listarComprasUsuarios(int idUsuario) throws Exception {
        return null;
    }

    public CompraGetDTO obtenerCompra(int idCompra) throws Exception {
        return null;
    }


}
