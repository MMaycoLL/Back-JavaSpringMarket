package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
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
public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    private Integer idUsuario;

    private Integer idProducto;

    private String idMetodoPago;


    private Integer idEnvio;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer totalCompra;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;
    // se esta agregando el metodo de pago para que se pueda hacer la relacion con la tabla metodo de pago
}
