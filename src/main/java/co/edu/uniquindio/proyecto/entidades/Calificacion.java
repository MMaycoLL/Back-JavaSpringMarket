package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Calificacion implements Serializable {
    @Id
    private Integer idCalificacion;

    private Integer idUsuario;

    private Integer idProducto;

    private Integer compra;

    private Integer valorCalificacion;

    private String comentario;
}
