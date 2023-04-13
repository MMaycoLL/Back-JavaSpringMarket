package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;

import java.util.List;

public interface CompraServicio {
    int crearCompra(CompraDTO compraDTO) throws Exception;

    List<CompraGetDTO> listarComprasUsuarios(int idUsuario) throws Exception;

    CompraGetDTO obtenerCompra(int idCompra) throws Exception;

}
