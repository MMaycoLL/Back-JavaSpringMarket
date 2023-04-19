package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailControlador {

    private final EmailServicio emailServicio;

    public void enviarEmail(EmailDTO emailDTO) throws Exception {
    }

}
