package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;

public interface ProductoModeradorServicio {

    void aprobarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception;

    void rechazarProducto(ProductoModeradorDTO productoModeradorDTO) throws Exception;

}
