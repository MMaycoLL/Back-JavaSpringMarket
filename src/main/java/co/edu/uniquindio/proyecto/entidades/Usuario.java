package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario extends Persona implements Serializable {



    @Column(length = 20, nullable = false)
    private String telefono;

    @Column(length = 100, nullable = false)
    private String direccion;


    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> comentario;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Calificacion> calificacion;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Favorito> favorito;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Compra> compra;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Producto> producto;

}
