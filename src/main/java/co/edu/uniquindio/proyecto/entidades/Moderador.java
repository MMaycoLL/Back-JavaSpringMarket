package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Moderador implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModerador;

    @Column(length = 100, nullable = false)
    private String nombreCompleto;

    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false, unique = true)
    private String cedula;

    @Column(length = 50, nullable = false)
    private String telefono;

    private String direccion;

    @Column(length = 100, nullable = false)
    private String contrasenia;
}

