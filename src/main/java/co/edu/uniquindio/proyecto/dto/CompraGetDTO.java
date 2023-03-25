package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO {

    @NotNull(message = "El id de la compra no puede ser nulo")
    private int idCompra;

    @NotNull(message = "La fecha de la compra no puede ser nula")
    @PastOrPresent(message = "La fecha de la compra debe ser igual o anterior a la fecha actual")
    private LocalDateTime fechaCompra;

    @NotNull(message = "El total de la compra no puede ser nulo")
    @Positive(message = "El total de la compra debe ser un número positivo")
    private float totalCompra;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private int idUsuario;

    @NotBlank(message = "El metodo de pago no puede estar vacío")
    @NotNull(message = "El metodo de pago no puede ser nulo")
    private MetodoPago metodoPago;

    @NotNull(message = "El detalle de la compra no puede ser nulo")
    @Size(min = 1, message = "Debe haber al menos un elemento en la lista")
    private List<DetalleCompraDTO> detalleCompraDTO;
}
