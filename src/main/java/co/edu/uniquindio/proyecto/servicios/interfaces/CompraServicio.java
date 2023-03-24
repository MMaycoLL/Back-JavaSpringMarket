package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;

import java.util.List;

public interface CompraServicio {
    int crearCompra(CompraDTO compraDTO);

    List<CompraGetDTO> listarComprasUsuarios(int idUsuario);

    CompraGetDTO obtenerCompra(int idCompra);

}
