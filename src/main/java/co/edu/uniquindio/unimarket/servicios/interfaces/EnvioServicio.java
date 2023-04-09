package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.entidades.Envio;

public interface EnvioServicio {

    Envio crearEnvio(EnvioDTO envioDTO, int idCompra) throws Exception;

    Envio actualizarEnvio(EnvioDTO envioDTO, int idEnvio) throws Exception;

    void eliminarEnvio(int idEnvio) throws Exception;
}
