package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @Column(nullable = false)
    private LocalDateTime fechaComentario;

    @Column(nullable = false, length = 1000, columnDefinition = "TEXT")
    private String comentario;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Producto producto;
    
}
