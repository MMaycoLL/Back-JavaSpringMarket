package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Calificacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalificacion;

    @Positive
    @Column(nullable = false)
    private Integer valorCalificacion;

    @Column(nullable = false, length = 1000, columnDefinition = "TEXT")
    private String comentarioCalificacion;

    @ManyToOne
    private Usuario usuario;
}
