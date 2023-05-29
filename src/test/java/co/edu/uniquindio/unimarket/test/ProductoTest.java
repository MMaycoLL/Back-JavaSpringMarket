package co.edu.uniquindio.unimarket.test;


import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.Categoria;
import co.edu.uniquindio.unimarket.entidades.enumeraciones.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

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
    @Sql("classpath:dataset.sql")
    public void crearProductoTest() {
        try {

            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Pepito 77",
                    "pepe129@email.com",
                    "1000000",
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProductoTest() {
        try {

            Map<String, String> imagenes = new HashMap<>();
            imagenes.put("img1", "https://www.google.com/imagen1.jpg");

            ProductoGetDTO productoActualizado = productoServicio.actualizarProducto(1,
                    new ProductoDTO(
                            "pelota",
                            "descripcion  producto v1",
                            10,
                            50000,
                            1,
                            imagenes,
                            List.of(Categoria.HOGAR)));

            //Se comprueba que ahora el nombre del producto no es el mismo inicial
            Assertions.assertNotEquals("balon", productoActualizado.getNombreProducto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProductoTest() {
        try {
            // Buscar un producto existente en el dataset para eliminarlo
            ProductoGetDTO productoDTO = productoServicio.obtenerProducto(1);

            // Eliminar el producto encontrado
            int productoEliminado = productoServicio.eliminarProducto(productoDTO.getIdProducto());

            // se espera que el producto no exista
            Assertions.assertThrows(Exception.class, () -> productoServicio.obtenerProducto(productoEliminado));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductoTest() {
        try {

            ProductoGetDTO productoObtenido = productoServicio.obtenerProducto(1);

            Assertions.assertEquals(50000, productoObtenido.getPrecioActual());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void actualizarPorUnidadesTest() {
        try {

            //Actualizar las unidades de un producto
            productoServicio.actualizarPorUnidades(1, 10);
            Producto productoActualizado = productoServicio.obtener(1);

            // se espera que las unidades hayan cambiado
            Assertions.assertEquals(10, productoActualizado.getUnidadesDisponibles());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPorEstadoTest() {
        try {

            //Actualizar el estado de un producto
            productoServicio.actualizarPorEstado(1, EstadoProducto.INACTIVO);
            Producto productoActualizado = productoServicio.obtener(1);

            // se espera que el estado haya cambiado
            Assertions.assertEquals(EstadoProducto.INACTIVO, productoActualizado.getEstadoProducto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosUsuarioTest() {
        try {

            // listar productos de un usuario
            List<ProductoGetDTO> productos = productoServicio.listarProductosUsuario(1);

            Assertions.assertEquals(1, productos.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosCategoriaTest() {
        try {

            // Listar productos de una categoría
            Categoria categoria = Categoria.HOGAR;
            List<ProductoGetDTO> productos = productoServicio.listarProductosCategoria(categoria);

            // Verificar que cada producto tenga la categoría buscada
            for (ProductoGetDTO p : productos) {
                Assertions.assertTrue(p.getCategorias().contains(categoria));
            }

            // Verificar que se encontraron la cantidad correcta de productos
            Assertions.assertEquals(1, productos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosEstadoTest() {
        try {

            // Listar productos de un estado
            EstadoProducto estado = EstadoProducto.ACTIVO;
            List<ProductoGetDTO> productos = productoServicio.listarProductosEstado(estado);

            Assertions.assertEquals(3, productos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarFavoritosUsuarioTest() {
        try {

            // Listar productos favoritos de un usuario
            List<ProductoGetDTO> lista = productoServicio.listarFavoritosUsuarios(1);

            Assertions.assertEquals(1, lista.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosNombreTest() {
        try {

            // Listar productos por nombre
            List<ProductoGetDTO> productos = productoServicio.listarProductosNombre("balon");

            Assertions.assertEquals(1, productos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosPrecioTest() {
        try {
            // Listar productos por precio
            List<ProductoGetDTO> productos = productoServicio.listarProductosPrecio(10000, 80000);

            Assertions.assertEquals(2, productos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test listar categorias
    @Test
    @Sql("classpath:dataset.sql")
    public void listarCategoriasTest() {
        try {
            // Listar categorias
            List<Categoria> categorias = productoServicio.listarCategorias();

            Assertions.assertEquals(5, categorias.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


