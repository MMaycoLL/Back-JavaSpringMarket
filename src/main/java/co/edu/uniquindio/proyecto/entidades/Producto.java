package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(nullable = false, length = 100)
    private String nombreProducto;

    @Column(nullable = false, length = 1000, columnDefinition = "TEXT")
    private String descripcionProducto;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer precioActual;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer disponibilidad;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Column(nullable = false)
    private String estadoProducto;

    @OneToMany(mappedBy = "producto")
    private List<Descuento> descuentos;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagen;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentario;

    @OneToMany(mappedBy = "producto")
    private List<Favorito> favorito;

    @ManyToOne
    private Usuario usuario;

}
