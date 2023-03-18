package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    private String nombreProducto;

    private String descripcionProducto;

    private int unidadesDisponibles;

    private float precioActual;

    private int idUsuario;

    private List<String> imagenes;

    private List<Categoria> categorias;
}
