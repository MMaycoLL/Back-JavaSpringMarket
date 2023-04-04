package co.edu.uniquindio.unimarket.entidades;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoAutorizacion;
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
@ToString(callSuper = true)
public class ProductoModerador implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductoModerador;

    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fechaAutorizacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAutorizacion estadoAutorizacion;

    @ManyToOne
    @JoinColumn(name = "idModerador", nullable = false)
    private Moderador moderador;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
}
