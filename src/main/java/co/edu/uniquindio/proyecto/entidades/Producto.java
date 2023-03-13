package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private Integer idUsuario;

    @Column(length = 100, nullable = false)
    private String nombreProducto;

    private String descripcionProducto;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer precioActual;

    private Boolean disponibilidad;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    private String estadoProducto;

}

