package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO {

    private int idComentario;

    private LocalDateTime fechaComentario;

    private String comentario;

    private int idProducto;

    private int idUsuario;

}
