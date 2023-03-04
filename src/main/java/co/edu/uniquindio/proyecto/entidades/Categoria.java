package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Categoria implements Serializable {
    @Id
    private Integer idCategoria;

    private String nombre;

    private String descripcion;
}
