package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioGetDTO {

    private int idUsuario;

    private String nombreCompleto;

    private String email;

    private String direccion;

    private String telefono;

    private String cedula;

}
