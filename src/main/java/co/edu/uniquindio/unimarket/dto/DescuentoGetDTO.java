package co.edu.uniquindio.unimarket.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DescuentoGetDTO {

    private int idProducto;

    private BigDecimal porcentajeDescuento;

    private LocalDate fechaInicioDescuento;

    private LocalDate fechaFinalDescuento;


}
