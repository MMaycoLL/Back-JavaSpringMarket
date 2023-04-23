package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CambiarContraseniaServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CambiarContraseniaServicioImpl implements CambiarContraseniaServicio {

    private final EmailServicio emailServicio;
    private final  UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void linkCambiarContrasenia(String email) throws Exception {

        if (Optional.ofNullable(usuarioRepo.findByEmail(email)).isEmpty()) {
            throw new UsernameNotFoundException("El email no existe");

        } else {
            emailServicio.enviarEmail(new EmailDTO(
                    "Solicitud cambiar password",
                    "Para recuperar su password debe dar clik en el enlace http://localhost:8080/api/cambiarContrasenia/cambiar/",
                    email
            ));
        }
    }

    @Override
    public void cambiarContrasenia(String correo) throws Exception {

    }


    @Override
    public void cambiarContrasenia(String email, String contrasenia) throws Exception {
        Usuario usuario = usuarioRepo.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("El email no existe");
        } else {
            usuario.setContrasenia(passwordEncoder.encode(contrasenia));
            usuarioRepo.save(usuario);
        }
    }
}









