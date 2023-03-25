package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TokenDTO {

    @NotNull(message = "El token no puede ser nulo")
    @NotBlank(message = "El token no puede estar vacío")
    private String token;

    @NotNull(message = "El estado no puede ser nulo")
    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

}
