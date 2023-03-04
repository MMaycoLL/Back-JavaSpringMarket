package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Descuento implements Serializable {
    @Id
    private Integer idDescuento;

    private Integer idProducto;

    private Integer idUsuario;

    private Integer porcentajeDescuento;

    private LocalDateTime fechaInicioDescuento;

    private LocalDateTime fechaFinDescuento;
}

