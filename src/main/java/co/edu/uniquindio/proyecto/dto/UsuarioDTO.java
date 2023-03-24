package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    //El @NotBlank es solo para los string
    @NotBlank(message =  "El nombre no puede estar vacío" )
    @NotNull(message =  "El nombre no puede ser nulo" )
    @Length(max =100, message =  "El nombre no puede tener más de 100 caracteres" )
    private String nombreCompleto;


    @NotBlank(message =  "El nombre no puede estar vacío" )
    @NotNull(message =  "El nombre no puede ser nulo" )
    @Length(max =100, message =  "El nombre no puede tener más de 100 caracteres" )
    private String email;

    @NotBlank(message =  "El nombre no puede estar vacío" )
    @NotNull(message =  "El nombre no puede ser nulo" )
    @Length(max =10, message =  "El nombre no puede tener más de 100 caracteres" )
    private String cedula;

    @NotBlank(message =  "El nombre no puede estar vacío" )
    @NotNull(message =  "El nombre no puede ser nulo" )
    @Length(max =100, message =  "El nombre no puede tener más de 100 caracteres" )
    private String direccion;

    @NotBlank(message =  "El nombre no puede estar vacío" )
    @NotNull(message =  "El nombre no puede ser nulo" )
    @Length(max =20, message =  "El nombre no puede tener más de 100 caracteres" )
    private String telefono;

    @NotBlank(message =  "El nombre no puede estar vacío" )
    @NotNull(message =  "El nombre no puede ser nulo" )
    @Length(max =100, message =  "El nombre no puede tener más de 100 caracteres" )
    private String contrasenia;
}
