package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoModeradorDTO {

    private EstadoProducto estadoAutorizacion;

    private LocalDateTime fechaAutorizacion;

    private String motivo;

    private int idModerador;

    private int idProducto;


}
