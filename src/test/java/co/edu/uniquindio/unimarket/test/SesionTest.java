package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class SesionTest {

    @Autowired
    private SesionServicio sesionServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void hacerLogin() throws Exception {

        TokenDTO tokenDTO = sesionServicio.login(new SesionDTO(
                "pepe1@gmail.com",
                "1234"
        ));

        System.out.println(tokenDTO.getToken());

    }
}
