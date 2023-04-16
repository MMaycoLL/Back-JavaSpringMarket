package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DescuentoDTO {

    @NotNull(message = "El id del producto no puede ser nulo")
    private int idProducto;

    @NotNull(message = "El porcentaje de descuento no puede ser nulo")
    @PositiveOrZero(message = "El porcentaje de descuento debe ser mayor o igual a 0")
    private BigDecimal porcentajeDescuento;

    @NotNull(message = "La fecha de inicio del descuento no puede ser nula")
    private LocalDate fechaInicioDescuento;

    @NotNull(message = "La fecha final del descuento no puede ser nula")
    @Future(message = "La fecha final del descuento debe ser futura")
    private LocalDate fechaFinalDescuento;


}
