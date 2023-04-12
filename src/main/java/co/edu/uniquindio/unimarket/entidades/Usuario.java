package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
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

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Envio> envio;
}
