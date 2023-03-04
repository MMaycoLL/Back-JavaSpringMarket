package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Usuario implements Serializable {
    @Id
    private Integer idUsuario;

    private String nombreCompleto;

    private String email;

    private String cedula;

    private String telefono;

    private String direccion;

    private String contrasenia;

}

