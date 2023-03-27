package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrarProducto() throws Exception {

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 77",
                "pepe127@email.com",
                "123007007",
                "Calle 12 #12",
                "343",
                "1234");


        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        //Se crea la colección de imágenes para el producto.
        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("im1", "http://www.google.com/images/imagenasus.png");
        imagenes.put("im2", "http://www.google.com/images/imagenasus_original.png");

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                "Producto 1",
                "Descripción del producto 1",
                10,
                100000,
                codigoVendedor,
                imagenes,
                List.of(Categoria.ELECTRONICA, Categoria.HOGAR),
                true
        );

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        //Se espera que el servicio retorne el código del nuevo producto
        Assertions.assertNotEquals(0, codigoProducto);
    }

}


