package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.enumeraciones.Ciudades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EnvioGetDTO {

    private int idEnvio;

    private String nombreDestinatario;

    private String direccionDestinatario;

    private String telefonoDestinatario;

    private Ciudades ciudadEnvio;


}
