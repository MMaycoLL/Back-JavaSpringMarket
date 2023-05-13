package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.EnvioDTO;
import co.edu.uniquindio.unimarket.dto.EnvioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Ciudades;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.EnvioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@SpringBootTest
@Transactional

public class EnvioTest {
    ;
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private EnvioServicio envioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearEnvioTest() {
        try {

            // Obtener la compra existente
            int idUsuario = 2;
            Optional<Usuario> usuario = usuarioRepo.findById(idUsuario);

            // Crear un objeto DTO con los datos del envío a crear
            EnvioDTO envioDTO = new EnvioDTO(
                    "juan perez",
                    "Calle 13 #13",
                    "31238522",
                    Ciudades.CAUCASIA,
                    1
            );

            // Crear el envío a partir del DTO
            EnvioGetDTO envioGetDTO = envioServicio.crearEnvio(envioDTO, idUsuario);

            // Verificar que el envío se actualizó correctamente
            Assertions.assertEquals("Calle 13 #13", envioGetDTO.getDireccionDestinatario());
            Assertions.assertEquals(Ciudades.CAUCASIA, envioGetDTO.getCiudadEnvio());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEnvioTest() {
        try {
            EnvioGetDTO envioGetDTO = envioServicio.actualizarEnvio(1,
                    new EnvioDTO(
                            "pepito perez",
                            "Calle 13 #20",
                            "31238522",
                            Ciudades.CALI,
                            1
                    ));

            // Se comprueba que el envío se actualizó correctamente
            Assertions.assertEquals("Calle 13 #20", envioGetDTO.getDireccionDestinatario());
            Assertions.assertEquals(Ciudades.CALI, envioGetDTO.getCiudadEnvio());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarEnvioTest() {
        try {
            // Buscar un envío existente en el dataset para eliminarlo
            EnvioGetDTO envioGetDTO = envioServicio.obtenerEnvio(1);

            // Eliminar el envío encontrado
            int EnvioEliminado = envioServicio.eliminarEnvio(envioGetDTO.getIdEnvio());

            // Verificar que el envío se eliminó correctamente
            Assertions.assertThrows(Exception.class, () ->
                    envioServicio.obtenerEnvio(EnvioEliminado)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
