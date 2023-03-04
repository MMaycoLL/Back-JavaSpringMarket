package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Comentario implements Serializable {
    @Id
    private String idComentario;

    private String idUsuario;

    private String idProducto;

    private LocalDateTime fechaComentario;

    private String comentario;
}

