package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    private int idProducto;

    private EstadoProducto estadoProducto;

    private LocalDateTime fechaLimite;

    private String nombreProducto;

    private String descripcionProducto;

    private int unidadesDisponibles;

    private float precioActual;

    private int idUsuario;

    private Map<String, String> imagenes;

    private List<Categoria> categorias;

}
