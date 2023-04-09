package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.Ciudades;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EnvioDTO {

    @NotBlank(message = "La direccion no puede estar vacía")
    @NotNull(message = "La direccion no puede ser nula")
    @Length(max = 100, message = "La direccion no puede tener más de 100 caracteres")
    private String direccionEnvio;

    @NotNull(message = "La ciudad no puede ser nula")
    private Ciudades ciudadEnvio;

    @NotNull(message = "El telefono no puede ser nulo")
    @Length(max = 20, message = "El telefono no puede tener más de 20 caracteres")
    @NotBlank(message = "El telefono no puede estar vacío")
    private String telefono;

    @NotNull(message = "La fecha de entrega estimada no puede ser nula")
    private LocalDate fechaEntregaEstimada;


}
