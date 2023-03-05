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
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@ToString
public class AutorizacionProducto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idAutorizacion;

    private Integer idProducto;

    private Integer idModerador;

    private String idEstado;

    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fechaAutorizacion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoAutorizacion estadoAutorizacion;
    // estamos creando una instancia de  enum para el estado de la autorizacion
}
