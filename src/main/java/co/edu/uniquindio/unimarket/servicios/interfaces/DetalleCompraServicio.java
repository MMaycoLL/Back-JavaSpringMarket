package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;

public interface DetalleCompraServicio {

    DetalleCompra crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception;

    // Obtener detalle de compra por id
    DetalleCompraGetDTO obtenerDetalleCompra(int idDetalleCompra) throws Exception;

    DetalleCompra obtener(int idDetalleCompra) throws Exception;
}
