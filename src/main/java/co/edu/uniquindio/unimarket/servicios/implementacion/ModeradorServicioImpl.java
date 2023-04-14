package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.entidades.Moderador;
import co.edu.uniquindio.unimarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {


    private final ModeradorRepo moderadorRepo;

    @Override
    public Moderador obtenerModeradorPorId(int idModerador) throws Exception {

        Optional<Moderador> moderadorOpt = moderadorRepo.findById(idModerador);
        if (moderadorOpt.isPresent()) {
            return moderadorOpt.get();
        } else {
            throw new Exception("Moderador no encontrado");
        }
    }


}

