package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Imagen implements Serializable {
    @Id
    private Integer idImagen;

    private Integer idProducto;

    private String url;

}
