package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDescuentoDTO {

    private int idProducto;

    private String nombre;

    private float precioActual;

    private float porcentajeDescuento;

}
