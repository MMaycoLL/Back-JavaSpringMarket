package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class DetalleCompraGetDTO {

    private int idDetalleCompra;

    private int cantidad;

    private float precioCompra;

    private int idProducto;
}
