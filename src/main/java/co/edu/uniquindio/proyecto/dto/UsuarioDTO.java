package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private String nombreCompleto;

    private String email;

    private String direccion;

    private String telefono;

    private String contrasenia;
}
