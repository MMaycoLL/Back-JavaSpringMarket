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
public class Envio implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer idEnvio;

    @Column(nullable = false)
    private String direccionEnvio;

    @Column(nullable = false)
    private LocalDateTime fechaEnvio;



}
