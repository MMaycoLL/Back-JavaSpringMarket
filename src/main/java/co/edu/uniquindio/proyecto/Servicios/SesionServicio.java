package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO sesionDTO);

    void logout(SesionDTO sesionDTO);
}
