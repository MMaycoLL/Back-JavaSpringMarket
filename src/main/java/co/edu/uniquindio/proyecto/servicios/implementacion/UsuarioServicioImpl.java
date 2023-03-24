package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {

        Usuario emailExistente = usuarioRepo.buscarUsuarioPorEmail(usuarioDTO.getEmail());
        if (emailExistente != null) {
            throw new Exception("El correo " + usuarioDTO.getEmail() + " ya está en uso");
        }

        Usuario cedulaExistente = usuarioRepo.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if (cedulaExistente != null) {
            throw new Exception("La cédula " + usuarioDTO.getCedula() + " ya está en uso");
        }


        Usuario usuario = convertir(usuarioDTO);


        return usuarioRepo.save(usuario).getIdPersona();
    }

    @Override
    public int registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        return 0;
    }

    @Override
    public int actualizarUsuario(int idUsuario, UsuarioDTO usuarioDTO) throws Exception {

        Usuario emailExistente = usuarioRepo.buscarUsuarioPorEmail(usuarioDTO.getEmail());
        if (emailExistente != null && emailExistente.getIdPersona() != idUsuario) {
            throw new Exception("El correo " + usuarioDTO.getEmail() + " ya está en uso");
        }

        Usuario cedulaExistente = usuarioRepo.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if (cedulaExistente != null && cedulaExistente.getIdPersona() != idUsuario) {
            throw new Exception("La cédula " + usuarioDTO.getCedula() + " ya está en uso");
        }

        validarExiste(idUsuario);


        Usuario usuario = convertir(usuarioDTO);
        usuario.setIdPersona(idUsuario);

        return usuarioRepo.save(usuario).getIdPersona();
    }


    @Override
    public int eliminarUsuario(int idUsuario) throws Exception {
        validarExiste(idUsuario);
        usuarioRepo.deleteById(idUsuario);
        return idUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception {
        return convertir(obtener(codigoUsuario));
    }

    private Usuario obtener(int codigoUsuario) throws Exception {
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

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(usuario.getIdPersona(), usuario.getNombreCompleto(), usuario.getEmail(), usuario.getDireccion(), usuario.getTelefono());


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