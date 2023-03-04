package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Favorito implements Serializable {
    @Id
    private Integer idFavorito;

    private Integer idUsuario;

    private Integer idProducto;

    private LocalDate fechaAgregado;

}
