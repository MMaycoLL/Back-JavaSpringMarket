package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Descuento implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDescuento;

    private Integer idProducto;

    private Integer idUsuario;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer porcentajeDescuento;

    @Column(nullable = false)
    private LocalDateTime fechaInicioDescuento;

    @Column(nullable = false)
    private LocalDateTime fechaFinDescuento;
}

