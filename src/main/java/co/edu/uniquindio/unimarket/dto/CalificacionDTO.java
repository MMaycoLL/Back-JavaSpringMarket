package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CalificacionDTO {

    @PositiveOrZero(message = "La calificación debe ser mayor o igual a 0")
    private float valorCalificaion;

    @NotNull(message = "El comentario no puede ser nulo")
    @NotBlank(message = "El comentario no puede estar vacío")
    private String comentarioCalificacion;

    private int idUsuario;

    private int idProductoCompra;

}
