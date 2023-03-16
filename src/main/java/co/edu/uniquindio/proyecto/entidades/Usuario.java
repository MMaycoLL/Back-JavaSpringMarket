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



    private Integer telefono;

    private String direccion;


    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;

    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> calificacion;

    @OneToMany(mappedBy = "usuario")
    private List<Favorito> favorito;

    @OneToMany(mappedBy = "usuario")
    private List<Compra> compra;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> producto;

}
