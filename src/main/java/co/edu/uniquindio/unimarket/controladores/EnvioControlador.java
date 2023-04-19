package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.EnvioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/envio")
@AllArgsConstructor
public class EnvioControlador {

    private final EnvioServicio envioServicio;

    public EnvioGetDTO crearEnvio(EnvioDTO envioDTO, int idUsuario) throws Exception {
        return null;
    }

    public EnvioGetDTO actualizarEnvio(int idEnvio, EnvioDTO envioDTO) throws Exception {
        return null;
    }

    public int eliminarEnvio(int idEnvio) throws Exception {
        return 0;
    }

    public EnvioGetDTO obtenerEnvio(int idEnvio) throws Exception {
        return null;
    }


}
