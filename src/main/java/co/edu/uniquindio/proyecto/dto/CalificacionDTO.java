package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CalificacionDTO {

    @PositiveOrZero(message = "La calificación debe ser mayor o igual a 0")
    private int valorCalificaion;

    @NotNull(message = "El comentario no puede ser nulo")
    @NotBlank(message = "El comentario no puede estar vacío")
    private String comentarioCalificacion;

    private int idUsuario;

    private int idProductoCompra;

}
