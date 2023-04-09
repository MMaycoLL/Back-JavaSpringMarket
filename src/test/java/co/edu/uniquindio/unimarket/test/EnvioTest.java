package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.Envio;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Ciudades;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.EnvioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@SpringBootTest

public class EnvioTest {

    @Autowired
    private EnvioRepo envioRepo;

    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearEnvioTest() throws Exception {

        // Obtener la compra existente
        int idCompra = 1;
        Compra compra = compraRepo.findById(idCompra)
                .orElseThrow(() -> new Exception("No se encontró la compra con el id especificado"));

        // Obtener el envío existente de la compra
        Envio envio = compra.getEnvio();
        Assertions.assertNotNull(envio, "La compra no tiene un envío asociado");

        // Modificar los atributos del envío existente
        envio.setDireccionEnvio("Calle 13 #13");
        envio.setCiudadEnvio(Ciudades.CALI);
        envio.setTelefono("7654321");
        envio.setFechaEntregaEstimada(LocalDate.parse("2022-01-01"));

        // Guardar los cambios en la base de datos
        envioRepo.save(envio);

        // Verificar que el envío se actualizó correctamente
        Assertions.assertEquals("Calle 13 #13", envio.getDireccionEnvio());
        Assertions.assertEquals(Ciudades.CALI, envio.getCiudadEnvio());
        Assertions.assertEquals("7654321", envio.getTelefono());
        Assertions.assertEquals(LocalDate.parse("2022-01-01"), envio.getFechaEntregaEstimada());
    }

}
