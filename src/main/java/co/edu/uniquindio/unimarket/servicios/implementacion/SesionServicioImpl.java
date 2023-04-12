package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.security.modelo.UserDetailsImpl;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.userdetails.UserDetails;

public class SesionServicioImpl implements SesionServicio {


    @Override
    public TokenDTO login(SesionDTO sesionDTO) {

        return null;
    }

    @Override
    public void logout(int idUsuario) {



    }
}
