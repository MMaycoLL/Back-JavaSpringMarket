package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.DescuentoGetDTO;

import java.math.BigDecimal;

public interface DescuentoServicio {

    void aplicarDescuento(DescuentoGetDTO descuentoGetDTO) throws Exception;

}

