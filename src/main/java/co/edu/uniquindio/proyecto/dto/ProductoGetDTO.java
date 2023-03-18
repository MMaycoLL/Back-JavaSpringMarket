package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    private int idProducto;

    private boolean estadoProducto;

    private LocalDateTime fechaLimite;

    private String nombreProducto;

    private String descripcionProducto;

    private int unidadesDisponibles;

    private float precioActual;

    private int idUsuario;

    private List<String> imagenes;

    private List<Categoria> categorias;


}
