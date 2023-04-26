package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDescuentoDTO {

    @NotNull(message = "El id del producto no puede ser nulo")
    private int idProducto;

    @NotNull(message = "El nombre del producto no puede ser nulo")
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del producto debe tener maximo 100 caracteres")
    private String nombre;

    @NotNull(message = "El precio actual no puede ser nulo")
    @PositiveOrZero(message = "El precio actual debe ser mayor o igual a cero")
    private float precioActual;

    @NotNull(message = "El porcentaje de descuento no puede ser nulo")
    @PositiveOrZero(message = "El porcentaje de descuento debe ser mayor o igual a cero")
    private float porcentajeDescuento;

}
