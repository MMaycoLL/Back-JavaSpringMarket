package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CalificacionGetDTO {

    private int idCalificacion;

    private int valorCalificaion;

    private String comentarioCalificacion;

    private int idUsuario;

    private int idProductoCompra;
}
