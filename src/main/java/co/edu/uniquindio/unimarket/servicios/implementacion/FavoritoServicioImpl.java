package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.entidades.Favorito;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.FavoritoRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.favorito.ProductoYaFavoritoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.producto.ProductoNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FavoritoServicioImpl implements FavoritoServicio {

    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    private final FavoritoRepo favoritoRepo;


    @Override
// Metodo que permite agregar un producto a la lista de favoritos de un usuario
    public void crearFavorito(FavoritoDTO favoritoDTO) throws Exception {
        Usuario usuario = usuarioServicio.obtener(favoritoDTO.getIdUsuario());
        Producto producto = productoServicio.obtener(favoritoDTO.getIdProducto());

        // Verificar si el producto ya está en la lista de favoritos del usuario
        boolean productoYaFavorito = usuario.getFavorito().stream().anyMatch(f -> f.getProducto().getIdProducto() == favoritoDTO.getIdProducto());

        if (!productoYaFavorito) {
            // Crear un nuevo objeto Favorito y guardarlo en la base de datos
            Favorito favorito = new Favorito();
            favorito.setUsuario(usuario);
            favorito.setProducto(producto);
            favorito.setFechaAgregado(LocalDateTime.now());
            favoritoRepo.save(favorito);
        } else {
            throw new ProductoYaFavoritoException("El producto ya está en la lista de favoritos del usuario.");
        }
    }

    @Override
    // Metodo que permite eliminar un producto de la lista de favoritos de un usuario
    public void eliminarFavorito(int idUsuario, int idProducto) throws Exception {
        Usuario usuario = usuarioServicio.obtener(idUsuario);
        Producto producto = productoServicio.obtener(idProducto);

        // Buscar el favorito correspondiente al usuario y al producto
        Favorito favorito = favoritoRepo.findByUsuarioAndProducto(usuario, producto).orElseThrow(()
                -> new ProductoNoEncontradoException("El producto no está en la lista de favoritos del usuario."));

        // Eliminar el favorito y guardar los cambios
        favoritoRepo.delete(favorito);

    }
}

