package co.edu.uniquindio.unimarket.entidades;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.Ciudades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Envio implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvio;

    @Column(length = 100, nullable = false)
    private String direccionEnvio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ciudades ciudadEnvio;

    @Column(length = 20, nullable = false)
    private String telefono;

    @Column(nullable = false)
    private LocalDate fechaEntregaEstimada;

    @OneToOne(mappedBy = "envio")
    @ToString.Exclude
    private Compra compra;

}
