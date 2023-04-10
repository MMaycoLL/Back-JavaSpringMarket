package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.EnvioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.Envio;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.EnvioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EnvioServicioImpl implements EnvioServicio {

    private final EnvioRepo envioRepo;
    private final CompraRepo compraRepo;

    @Override
    public EnvioGetDTO crearEnvio(EnvioDTO envioDTO, int idCompra) throws Exception {

        // Verificar si el id de la compra es válido
        if (!compraRepo.existsById(idCompra))
            throw new Exception("No se encontró la compra con el id suministrado");

        // Recuperar la compra de la base de datos
        Compra compra = compraRepo.findById(idCompra).get();

        Envio envio = convertir(envioDTO);

        if (compra.getEnvio() != null) {
            // Actualizar el envío existente con los nuevos datos
            envio = compra.getEnvio();
            envio.setDireccionEnvio(envioDTO.getDireccionEnvio());
            envio.setCiudadEnvio(envioDTO.getCiudadEnvio());
            envio.setTelefono(envioDTO.getTelefono());
            envio.setFechaEntregaEstimada(envioDTO.getFechaEntregaEstimada());
        } else {
            // Establecer la relación entre el envío y la compra
            compra.setEnvio(envio);
            envio.setCompra(compra);
        }

        envioRepo.save(envio);

        return convertir(envio);
    }

    @Override
    public EnvioGetDTO actualizarEnvio(int idEnvio, EnvioDTO envioDTO) throws Exception {

        // Verificar si el id del envío es válido
        if (!envioRepo.existsById(idEnvio))
            throw new Exception("No se encontró el envío con el id suministrado");

        // Recuperar el envío de la base de datos
        Envio envio = convertir(envioDTO);

        envio.setIdEnvio(idEnvio);

        return convertir(envioRepo.save(envio));
    }


    @Override
    public int eliminarEnvio(int idEnvio) throws Exception {

        // Verificar si el id del envío es válido
        if (!envioRepo.existsById(idEnvio))
            throw new Exception("No se encontró el envío con el id suministrado");

        // Recuperar el envío de la base de datos
        Envio envio = envioRepo.findById(idEnvio).get();

        // Eliminar el envío
        envioRepo.delete(envio);

        return idEnvio;
    }

    @Override
    public EnvioGetDTO obtenerEnvio(int idEnvio) throws Exception {
        return convertir(obtener(idEnvio));
    }


    public Envio obtener(int idEnvio) throws Exception {
        Optional<Envio> envio = envioRepo.findById(idEnvio);

        if (envio.isEmpty()) {
            throw new Exception("el codigo" + idEnvio + "no esta asociado a ningun envio");
        }

        return envio.get();
    }

    private EnvioGetDTO convertir(Envio envio) {
        EnvioGetDTO envioGetDTO = new EnvioGetDTO();
        envioGetDTO.setIdEnvio(envio.getIdEnvio());
        envioGetDTO.setDireccionEnvio(envio.getDireccionEnvio());
        envioGetDTO.setCiudadEnvio(envio.getCiudadEnvio());
        envioGetDTO.setTelefono(envio.getTelefono());
        envioGetDTO.setFechaEntregaEstimada(envio.getFechaEntregaEstimada());
        return envioGetDTO;
    }

    private Envio convertir(EnvioDTO envioDTO) throws Exception {

        Envio envio = new Envio();
        envio.setDireccionEnvio(envioDTO.getDireccionEnvio());
        envio.setCiudadEnvio(envioDTO.getCiudadEnvio());
        envio.setTelefono(envioDTO.getTelefono());
        envio.setFechaEntregaEstimada(envioDTO.getFechaEntregaEstimada());

        return envio;
    }
}

