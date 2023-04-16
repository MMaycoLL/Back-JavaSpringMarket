package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.MetodoPago;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompraDTO {

    @NotBlank(message = "El metodo de pago no puede estar vacío")
    @NotNull(message = "El metodo de pago no puede ser nulo")
    private MetodoPago metodoPago;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private int idPersona;

    @NotNull(message = "El detalle de la compra no puede ser nulo")
    @Size(min = 1, message = "Debe haber al menos un elemento en la lista")
    private List<DetalleCompraDTO> detalleCompraDTO;

    @NotNull(message = "El id del envio no puede ser nulo")
    private int idEnvio;
}
