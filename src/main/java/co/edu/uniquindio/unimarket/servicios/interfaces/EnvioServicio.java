package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.EnvioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Envio;

public interface EnvioServicio {

    EnvioGetDTO crearEnvio(EnvioDTO envioDTO, int idUsuario) throws Exception;

    EnvioGetDTO actualizarEnvio(int idEnvio, EnvioDTO envioDTO) throws Exception;

    int eliminarEnvio(int idEnvio) throws Exception;

    EnvioGetDTO obtenerEnvio(int idEnvio) throws Exception;

    Envio obtener (int idEnvio) throws Exception;
}
