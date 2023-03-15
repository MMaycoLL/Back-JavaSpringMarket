package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@ToString
public class Descuento implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer idDescuento;

    @Positive
    @Column(nullable = false)
    private Integer porcentajeDescuento;

    @Column(nullable = false)
    private LocalDateTime fechaInicioDescuento;

    @Column(nullable = false)
    private LocalDateTime fechaFinDescuento;


}
