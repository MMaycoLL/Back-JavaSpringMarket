package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.usuario.CedulaNoCoincideConUsuarioException;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.RecuperarContraseniaServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecuperarContraseniaServicioImpl implements RecuperarContraseniaServicio {

    private final EmailServicio emailServicio;
    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void linkCambiarContrasenia(String email) throws Exception {

        Usuario usuario = usuarioRepo.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("El email no existe en la base de datos");
        } else {
            emailServicio.enviarEmail(new EmailDTO(
                    "Solicitud de cambio de contraseña",
                    "Para recuperar su contraseña debe dar click en el enlace http://localhost:8080/doc/swagger-ui/index.html#/cambiar-contrasenia-controlador/cambiarContrasenia",
                    email
            ));
        }
    }

    @Override
    public void cambiarContrasenia(String email, String cedula, String contrasenia) throws Exception {
        Usuario usuario = usuarioRepo.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("El email no existe en la base de datos");
        }
        if (!usuario.getCedula().equals(cedula)) {
            throw new CedulaNoCoincideConUsuarioException("La cedula no coincide con la del usuario registrado con el email");
        }
        usuario.setContrasenia(passwordEncoder.encode(contrasenia));
        usuarioRepo.save(usuario);
        emailServicio.enviarEmail(new EmailDTO(
                "Cambio de contraseña",
                "Su contraseña ha sido cambiada exitosamente",
                email
        ));
    }
}









