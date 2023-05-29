package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.usuario.CedulaDuplicadaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.usuario.CodigoInexistenteException;
import co.edu.uniquindio.unimarket.servicios.excepciones.usuario.ContraseniaUsuarioNoCoincideException;
import co.edu.uniquindio.unimarket.servicios.excepciones.usuario.EmailDuplicadoException;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {

        validarEmailExistente(usuarioDTO);

        validarCedulaExistente(usuarioDTO);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setContrasenia(passwordEncoder.encode(usuarioDTO.getContrasenia()));
        Usuario registro = usuarioRepo.save(usuario);
        return registro.getIdPersona();
    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int idUsuario, UsuarioDTO usuarioDTO) throws Exception {

        validarEmailExistente(usuarioDTO);

        validarCedulaExistente(usuarioDTO);

        validarExistenciaUsuario(idUsuario);


        Usuario usuario = convertir(usuarioDTO);

        usuario.setIdPersona(idUsuario);

        return convertir(usuarioRepo.save(usuario));
    }


    @Override
    public int eliminarUsuario(int idUsuario) throws Exception {


        // Verificar que el usuario exista
        validarExistenciaUsuario(idUsuario);

        usuarioRepo.deleteById(idUsuario);

        return idUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int idUsuario) throws Exception {
        return convertir(obtener(idUsuario));
    }

    public Usuario obtener(int idUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(idUsuario);

        if (usuario.isEmpty()) {
            throw new CodigoInexistenteException("El código " + idUsuario + " no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    // Metodo para verificar que el email no este duplicado
    private void validarEmailExistente(UsuarioDTO usuarioDTO) throws Exception {
        Usuario emailExistente = usuarioRepo.buscarUsuarioPorEmail(usuarioDTO.getEmail());
        if (emailExistente != null) {
            throw new EmailDuplicadoException("El correo " + usuarioDTO.getEmail() + " ya está asignado a otro usuario, intente con otro");
        }
    }

    // Metodo para verificar que la cedula no este duplicada
    private void validarCedulaExistente(UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> cedulaExistente = usuarioRepo.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if (cedulaExistente.isPresent()) {
            throw new CedulaDuplicadaException("La cédula " + usuarioDTO.getCedula() + " ya está asignada a otro usuario, verifica que sea correcta");
        }
    }

    // Metodo para verificar que el usuario exista
    private void validarExistenciaUsuario(int idUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(idUsuario);

        if (!existe) {
            throw new CodigoInexistenteException("El código " + idUsuario + " no está asociado a ningún usuario");
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
        usuario.setContrasenia(passwordEncoder.encode(usuarioDTO.getContrasenia()));

        return usuario;
    }

}