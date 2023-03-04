package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class AutorizacionProducto implements Serializable {
    @Id
    private Integer idAutorizacion;

    private Integer idProducto;

    private Integer idModerador;

    private String estado;

    private String motivo;

    private LocalDateTime fechaAutorizacion;

}
