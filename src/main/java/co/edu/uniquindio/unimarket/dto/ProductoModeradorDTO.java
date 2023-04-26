package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoModeradorDTO {

    @NotNull(message = "La fecha de autorizacion no puede ser nula")
    private LocalDateTime fechaAutorizacion;

    @NotNull(message = "El motivo no puede ser nulo")
    @NotBlank(message = "El motivo no puede estar vacío")
    @Size(max = 500, message = "El motivo debe tener maximo 500 caracteres")
    private String motivo;

    @NotNull(message = "El id del moderador no puede ser nulo")
    private int idModerador;

    @NotNull(message = "El id del producto no puede ser nulo")
    private int idProducto;

}
