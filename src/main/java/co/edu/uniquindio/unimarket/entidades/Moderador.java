package co.edu.uniquindio.unimarket.entidades;

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
public class Moderador extends Persona implements Serializable {

    @OneToMany(mappedBy = "moderador")
    @ToString.Exclude
    private List<ProductoModerador> productoModerador;


}
