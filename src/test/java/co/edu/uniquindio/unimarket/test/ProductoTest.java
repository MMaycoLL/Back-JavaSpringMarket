package co.edu.uniquindio.unimarket.test;


import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest

public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearProductoTest() throws Exception {

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 77",
                "pepe12239@email.com",
                "100023000",
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
                "Producto de prueba",
                "Descripción del producto de prueba",
                10,
                10000,
                codigoVendedor,
                imagenes,
                List.of(Categoria.ELECTRONICA)
        );

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        //Se espera que el servicio retorne el código del nuevo producto
        Assertions.assertNotEquals(0, codigoProducto);
    }


    @Test
    public void actualizarProductoTest() throws Exception {

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 77",
                "pepe1234@email.com",
                "1023007",
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
                "Producto de prueba",
                "Descripción del producto de prueba",
                10,
                10000,
                codigoVendedor,
                imagenes,
                List.of(Categoria.ELECTRONICA));

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        ProductoGetDTO productoActualizado = productoServicio.actualizarProducto(codigoProducto, new ProductoDTO(
                "Producto de prueba",
                "Descripción del producto de prueba",
                10,
                1000,
                codigoVendedor,
                imagenes,
                List.of(Categoria.ELECTRONICA)));

        Assertions.assertNotEquals("1234", productoActualizado.getPrecioActual());

    }

    @Test
    public void eliminarProductoTest() throws Exception {

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
                "Producto de prueba",
                "Descripción del producto de prueba",
                10,
                10000,
                codigoVendedor,
                imagenes,
                List.of(Categoria.ELECTRONICA));

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        // una vez creado el producto se elimina
        int productoEliminado = productoServicio.eliminarProducto(codigoProducto);

        // se espera que el producto no exista
        Assertions.assertThrows(Exception.class, () -> productoServicio.obtenerProducto(productoEliminado));


    }

    @Test
    public void obtenerProductoTest() throws Exception {

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
                "Producto de prueba",
                "Descripción del producto de prueba",
                10,
                10000,
                codigoVendedor,
                imagenes,
                List.of(Categoria.ELECTRONICA));

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        // sa llama el servicio para obtener el producto dado su codigo

        ProductoGetDTO productoObtenido = productoServicio.obtenerProducto(codigoProducto);

        Assertions.assertEquals(10000, productoObtenido.getPrecioActual());
    }


    @Test
    public void actualizarPorUnidadesTest() throws Exception {

    }

    @Test
    public void actualizarPorEstadoTest() throws Exception {

    }
    @Test
    public void listarProductosUsuarioTest() throws Exception {

    }

    @Test
    public void listarProductosCategoriaTest() throws Exception {

    }

    @Test
    public void listarProductosEstadoTest() throws Exception {

    }

    @Test
    public void listarFavoritosUsuarioTest() throws Exception {

    }

    @Test
    public void listarProductosNombreTest() throws Exception {

    }

    @Test
    public void listarProductosPrecioTest() throws Exception {

    }

}


