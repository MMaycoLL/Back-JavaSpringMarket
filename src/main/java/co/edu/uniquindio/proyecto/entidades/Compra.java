package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Compra implements Serializable {
    @Id
    private Integer idCompra;

    private Integer idUsuario;

    private Integer idProducto;

    private String idMetodoPago;

    private Integer totalCompra;

    private LocalDateTime fechaCompra;

}
