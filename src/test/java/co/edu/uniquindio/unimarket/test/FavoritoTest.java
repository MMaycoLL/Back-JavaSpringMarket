package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional

public class FavoritoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private FavoritoServicio favoritoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearFavoritoTest() throws Exception {
        // Obtener un usuario y un producto existente del dataset
        UsuarioGetDTO usuarioDTO = usuarioServicio.obtenerUsuario(1);
        ProductoGetDTO productoDTO = productoServicio.obtenerProducto(3);

        // Ejecutar el método crearFavorito
        favoritoServicio.crearFavorito(usuarioDTO.getIdUsuario(), productoDTO.getIdProducto());

        // Verificar que el producto se haya agregado a la lista de favoritos del usuario
        List<ProductoGetDTO> lista = productoServicio.listarFavoritosUsuarios(usuarioDTO.getIdUsuario());
        Assertions.assertEquals(3, lista.size());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFavoritoTest() throws Exception {
        // Obtener un usuario y un producto existente del dataset
        UsuarioGetDTO usuarioDTO = usuarioServicio.obtenerUsuario(1);
        ProductoGetDTO productoDTO = productoServicio.obtenerProducto(1);

        // Ejecutar el método eliminarFavorito
        favoritoServicio.eliminarFavorito(usuarioDTO.getIdUsuario(), productoDTO.getIdProducto());

        // Verificar que el producto se haya eliminado de la lista de favoritos del usuario
        List<ProductoGetDTO> lista = productoServicio.listarFavoritosUsuarios(usuarioDTO.getIdUsuario());
        Assertions.assertEquals(1, lista.size());

    }

}



