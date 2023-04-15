package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.EnvioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Envio;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.EnvioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EnvioServicioImpl implements EnvioServicio {

    private final EnvioRepo envioRepo;

    private final UsuarioServicio usuarioServicio;

    @Override
    public EnvioGetDTO crearEnvio(EnvioDTO envioDTO, int idUsuario) throws Exception {

        // Verificar si el id del usuario es válido
        Usuario usuario = usuarioServicio.obtener(idUsuario);

        Envio envio = convertir(envioDTO);
        envio.setNombreDestinatario(envioDTO.getNombreDestinatario());
        envio.setDireccionDestinatario(envioDTO.getDireccionDestinatario());
        envio.setTelefonoDestinatario(envioDTO.getTelefonoDestinatario());
        envio.setCiudadEnvio(envioDTO.getCiudadEnvio());
        envio.setUsuario(usuario);

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
        envioGetDTO.setNombreDestinatario(envio.getNombreDestinatario());
        envioGetDTO.setDireccionDestinatario(envio.getDireccionDestinatario());
        envioGetDTO.setTelefonoDestinatario(envio.getTelefonoDestinatario());
        envioGetDTO.setCiudadEnvio(envio.getCiudadEnvio());

        return envioGetDTO;
    }

    private Envio convertir(EnvioDTO envioDTO) throws Exception {

        Envio envio = new Envio();
        envio.setNombreDestinatario(envioDTO.getNombreDestinatario());
        envio.setDireccionDestinatario(envioDTO.getDireccionDestinatario());
        envio.setTelefonoDestinatario(envioDTO.getTelefonoDestinatario());
        envio.setCiudadEnvio(envioDTO.getCiudadEnvio());

        return envio;
    }
}

