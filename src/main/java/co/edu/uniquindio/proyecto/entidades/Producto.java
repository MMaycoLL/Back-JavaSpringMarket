package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(nullable = false, length = 100)
    private String nombreProducto;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcionProducto;

    @PositiveOrZero
    @Column(nullable = false)
    private float precioActual;

    @PositiveOrZero
    @Column(nullable = false)
    private int unidadesDisponibles;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private boolean ACTIVO = true ;

    @OneToMany(mappedBy = "producto")
    private List<Descuento> descuentos;

    @ElementCollection
    private Map<String, String> Imagen;

    @Enumerated(EnumType.STRING)
   @Column(nullable = false, length = 50)
    private List <Categoria> categorias;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> comentario;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Favorito> favorito;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<ProductoCompra> productoCompra;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<ProductoModerador> productoModerador;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;


}
