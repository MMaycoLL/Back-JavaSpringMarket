package co.edu.uniquindio.unimarket.entidades;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.Ciudades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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
    private String nombreDestinatario;

    @Column(length = 100, nullable = false)
    private String direccionDestinatario;

    @Column(length = 20, nullable = false)
    private String telefonoDestinatario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ciudades ciudadEnvio;

    @OneToMany(mappedBy = "envio")
    @ToString.Exclude
    private List<Compra> compra;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
}
