package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Comentario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer idComentario;

    @Column(nullable = false)
    private LocalDateTime fechaComentario;

    @Column(nullable = false, length = 1000, columnDefinition = "TEXT")
    private String comentario;


}
