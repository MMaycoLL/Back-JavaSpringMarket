package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.AttributeException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {

        // Verificar que el correo no esté en uso
        Usuario emailExistente = usuarioRepo.buscarUsuarioPorEmail(usuarioDTO.getEmail());
        if (emailExistente != null) {
            throw new Exception("El correo " + usuarioDTO.getEmail() + " ya está en uso");
        }
        // Verificar que la cédula no esté en uso
        Usuario cedulaExistente = usuarioRepo.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if (cedulaExistente != null) {
            throw new Exception("La cédula " + usuarioDTO.getCedula() + " ya está en uso");
        }

        // Verificar que el nombre no exceda un número máximo de caracteres permitidos
        if (usuarioDTO.getNombreCompleto() != null && usuarioDTO.getNombreCompleto().length() > 100) {
            throw new Exception("El nombre no debe exceder los 100 caracteres.");
        }

        // Verificar que la cédula no exceda un número máximo de caracteres permitidos
        if (usuarioDTO.getCedula() != null && usuarioDTO.getCedula().length() > 10) {
            throw new Exception("La cédula no debe exceder los 10 caracteres.");
        }

        // Verificar que el nombre no sea nulo
        if (usuarioDTO.getNombreCompleto() == null) {
            throw new Exception("El nombre no puede ser nulo.");
        }

        // Verificar que la cédula no sea nula
        if (usuarioDTO.getCedula() == null) {
            throw new Exception("La cédula no puede ser nula.");
        }

        Usuario usuario = convertir(usuarioDTO);

        return usuarioRepo.save(usuario).getIdPersona();
    }


    @Override
    public int registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
       return crearUsuario(usuarioDTO);
    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int idUsuario, UsuarioDTO usuarioDTO) throws Exception {

        // Verificar que el correo no esté en uso
        Usuario emailExistente = usuarioRepo.buscarUsuarioPorEmail(usuarioDTO.getEmail());
        if (emailExistente != null && emailExistente.getIdPersona() != idUsuario) {
            throw new Exception("El correo " + usuarioDTO.getEmail() + " ya está en uso");
        }
        // Verificar que la cédula no esté en uso
        Usuario cedulaExistente = usuarioRepo.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if (cedulaExistente != null && cedulaExistente.getIdPersona() != idUsuario) {
            throw new Exception("La cédula " + usuarioDTO.getCedula() + " ya está en uso");
        }


        validarExiste(idUsuario);


        Usuario usuario = convertir(usuarioDTO);
        usuario.setIdPersona(idUsuario);

        return convertir(usuarioRepo.save(usuario));
    }


    @Override
    public int eliminarUsuario(int idUsuario) throws Exception {

        // Verificar que el usuario exista
        validarExiste(idUsuario);

        usuarioRepo.deleteById(idUsuario);

        return idUsuario;
    }



    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception {
        return convertir(obtener(codigoUsuario));
    }

    public Usuario obtener(int codigoUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if (usuario.isEmpty()) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    private void validarExiste(int codigoUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if (!existe) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }

    }

    private UsuarioGetDTO convertir(Usuario usuario) {

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getIdPersona(),
                usuario.getNombreCompleto(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getCedula());


        return usuarioDTO;
    }

    private Usuario convertir(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(usuarioDTO.getNombreCompleto());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setContrasenia(usuarioDTO.getContrasenia());

        return usuario;
    }

}