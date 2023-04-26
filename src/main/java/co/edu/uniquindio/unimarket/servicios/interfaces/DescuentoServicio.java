package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDescuentoDTO;
import co.edu.uniquindio.unimarket.entidades.Descuento;

import java.util.List;

public interface DescuentoServicio {

    void aplicarDescuento(DescuentoDTO descuentoDTO) throws Exception;


}

