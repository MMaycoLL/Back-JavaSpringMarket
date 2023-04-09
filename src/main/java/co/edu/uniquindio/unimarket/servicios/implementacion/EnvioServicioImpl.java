package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.Envio;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.EnvioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnvioServicioImpl implements EnvioServicio {

    private final EnvioRepo envioRepo;
    private final CompraRepo compraRepo;

    @Override
    public Envio crearEnvio(EnvioDTO envioDTO, int idCompra) throws Exception {

        // Recuperar la compra de la base de datos
        Compra compra = compraRepo.findById(idCompra)
                .orElseThrow(() -> new Exception("No se encontró la compra con el id especificado"));

        Envio envio;

        if (compra.getEnvio() != null) {
            // Actualizar el envío existente con los nuevos datos
            envio = compra.getEnvio();
        } else {
            // Crear un nuevo envío
            envio = new Envio();
            envio.setDireccionEnvio(envioDTO.getDireccionEnvio());
            envio.setCiudadEnvio(envioDTO.getCiudadEnvio());
            envio.setTelefono(envioDTO.getTelefono());
            envio.setFechaEntregaEstimada(envioDTO.getFechaEntregaEstimada());

            // Establecer la relación entre el envío y la compra
            compra.setEnvio(envio);
            envio.setCompra(compra);

            envioRepo.save(envio);
        }

        return envio;
    }

    @Override
    public Envio actualizarEnvio(EnvioDTO envioDTO, int idEnvio) throws Exception {

        // Recuperar el envío de la base de datos
        Envio envio = envioRepo.findById(idEnvio)
                .orElseThrow(() -> new Exception("No se encontró el envío con el id especificado"));

        // Actualizar los atributos del envío
        envio.setDireccionEnvio(envioDTO.getDireccionEnvio());
        envio.setCiudadEnvio(envioDTO.getCiudadEnvio());
        envio.setTelefono(envioDTO.getTelefono());
        envio.setFechaEntregaEstimada(envioDTO.getFechaEntregaEstimada());

        // Guardar los cambios en la base de datos
        envioRepo.save(envio);

        return envio;
    }


    @Override
    public void eliminarEnvio(int idEnvio) throws Exception {

        // Recuperar el envío de la base de datos
        Envio envio = envioRepo.findById(idEnvio)
                .orElseThrow(() -> new Exception("No se encontró el envío con el id especificado"));

        // Eliminar el envío
        envioRepo.delete(envio);

    }
}

