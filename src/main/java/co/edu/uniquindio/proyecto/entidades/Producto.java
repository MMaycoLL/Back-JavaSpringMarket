package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Producto implements Serializable {
    @Id
    private Integer idProducto;

    private Integer idUsuario;

    private String nombre;

    private String descripcion;

    private Integer precioActual;

    private Boolean disponibilidad;

    private LocalDate fechaLimite;

    private String estadoProducto;

}

