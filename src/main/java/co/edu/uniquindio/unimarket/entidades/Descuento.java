package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


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
    private float porcentajeDescuento;

    @Column(nullable = false)
    private LocalDate fechaInicioDescuento;

    @Column(nullable = false)
    private LocalDate fechaFinalDescuento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;

}
