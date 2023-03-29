package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraDTO {

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad mínima es 1")
    @Max(value = 100, message = "La cantidad máxima es 100")
    private int cantidad;

    @NotNull(message = "El precio de compra no puede ser nulo")
    @PositiveOrZero(message = "El precio de compra debe ser mayor o igual a cero")
    private float precioCompra;

    @NotNull(message = "El id del producto no puede ser nulo")
    private int idProducto;
}
