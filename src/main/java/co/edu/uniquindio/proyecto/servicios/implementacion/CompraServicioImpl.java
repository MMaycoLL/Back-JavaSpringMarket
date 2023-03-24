package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;

import java.util.List;

public class CompraServicioImpl implements CompraServicio {
    @Override
    public int crearCompra(CompraDTO compraDTO) {
        return 0;
    }

    @Override
    public List<CompraGetDTO> listarComprasUsuarios(int idUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int idCompra) {
        return null;
    }
}
