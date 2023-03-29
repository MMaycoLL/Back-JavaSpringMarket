package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Descuento implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDescuento;

    @Column(nullable = false)
    private int porcentajeDescuento;

    @Column(nullable = false)
    private LocalDateTime fechaInicioDescuento;

    @Column(nullable = false)
    private LocalDateTime fechaFinalDescuento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;

}
