package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CalificacionGetDTO {

    private int idCalificacion;

    private float valorCalificaion;

    private String comentarioCalificacion;

    private int idUsuario;

    private int idProductoCompra;
}
