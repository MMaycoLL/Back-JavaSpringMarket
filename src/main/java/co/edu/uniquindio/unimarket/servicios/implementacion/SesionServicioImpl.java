package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.unimarket.seguridad.servicios.JwtService;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SesionServicioImpl implements SesionServicio {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sesionDTO.getEmail(),
                        sesionDTO.getContrasenia())
        );

        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        return new TokenDTO(jwtToken);
    }

    @Override
    public void logout(int idUsuario) {

    }
}
