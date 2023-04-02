package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO {

    private int idCompra;

    private LocalDateTime fechaCompra;

    private float totalCompra;

    private int idUsuario;

    private MetodoPago metodoPago;

    private List<DetalleCompraDTO> detalleCompraDTO;
}
