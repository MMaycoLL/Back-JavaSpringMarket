package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Categoria implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer idCategoria;

    @Column(nullable = false, length = 100)
    private String nombreCategoria;

    @Column(nullable = false, length = 500, columnDefinition = "TEXT")
    private String descripcionCategoria;

}
