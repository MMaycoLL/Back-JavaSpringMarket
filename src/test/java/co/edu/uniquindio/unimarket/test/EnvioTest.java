package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.EnvioGetDTO;
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
@Transactional

public class EnvioTest {

    @Autowired
    private EnvioRepo envioRepo;

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private EnvioServicio envioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearEnvioTest() throws Exception {

        // Obtener la compra existente
        int idCompra = 1;
        Compra compra = compraRepo.findById(idCompra).get();

        // Crear un objeto DTO con los datos del envío a crear
        EnvioDTO envioDTO = new EnvioDTO(
                "Calle 13 #13",
                Ciudades.CAUCASIA,
                "7654321",
                LocalDate.parse("2022-01-01"));

        // Crear el envío a partir del DTO
        EnvioGetDTO envioGetDTO = envioServicio.crearEnvio(envioDTO, idCompra);

        // Verificar que el envío se actualizó correctamente
       Assertions.assertEquals("Calle 13 #13", envioGetDTO.getDireccionEnvio());
        Assertions.assertEquals(Ciudades.CAUCASIA, envioGetDTO.getCiudadEnvio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEnvioTest() throws Exception {

        EnvioGetDTO envioGetDTO = envioServicio.actualizarEnvio(1,
                new EnvioDTO(
                        "Calle 13 #20",
                        Ciudades.CALI,
                        "7654321",
                        LocalDate.parse("2022-01-01")));

        // Se comprueba que el envío se actualizó correctamente
        Assertions.assertEquals("Calle 13 #20", envioGetDTO.getDireccionEnvio());
        Assertions.assertEquals(Ciudades.CALI, envioGetDTO.getCiudadEnvio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarEnvioTest() throws Exception {

        // Buscar un envío existente en el dataset para eliminarlo
        EnvioGetDTO envioGetDTO = envioServicio.obtenerEnvio(1);

        // Eliminar el envío encontrado
        int EnvioEliminado = envioServicio.eliminarEnvio(envioGetDTO.getIdEnvio());

        // Verificar que el envío se eliminó correctamente
        Assertions.assertThrows(Exception.class, () ->
                envioServicio.obtenerEnvio(EnvioEliminado)
        );
    }

}
