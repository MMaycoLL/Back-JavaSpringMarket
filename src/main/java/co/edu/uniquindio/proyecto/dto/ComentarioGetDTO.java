package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO {

    @NotNull(message = "El id del comentario no puede ser nulo")
    private int idComentario;

    @NotNull(message = "La fecha del comentario no puede ser nula")
    @PastOrPresent(message = "La fecha del comentario debe ser en el pasado o en el presente")
    private LocalDateTime fechaComentario;

    @NotBlank(message = "El comentario no puede estar vacío")
    @NotNull(message = "El comentario no puede ser nulo")
    @Size(max = 500, message = "El comentario debe tener maximo 500 caracteres")
    private String comentario;

    @NotNull(message = "El id del producto no puede ser nulo")
    private int idProducto;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private int idUsuario;


}
