package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional

public class EmailTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void enviarEmailTest() {
        try {
            emailServicio.enviarEmail(new EmailDTO(
                    "Correo de prueba",
                    "Este es un correo de prueba",
                    "wolf.malign@gmail.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
