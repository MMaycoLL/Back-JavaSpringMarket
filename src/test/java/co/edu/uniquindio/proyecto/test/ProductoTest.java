package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
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

public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearProducto() throws Exception {

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 77",
                "pepe12000709@email.com",
                "100100000",
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
    public void actualizarProducto() throws Exception {

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
        productoServicio.eliminarProducto(codigoProducto);

        // se espera que el producto no exista
        Assertions.assertNull(productoServicio.obtenerProducto(codigoProducto));
    }




}

