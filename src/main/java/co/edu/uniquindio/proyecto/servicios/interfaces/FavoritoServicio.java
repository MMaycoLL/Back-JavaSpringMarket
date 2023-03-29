package co.edu.uniquindio.proyecto.servicios.interfaces;

public interface FavoritoServicio {

    int crearFavorito(int idUsuario, int idProducto);

    int eliminarFavorito(int idUsuario, int idProducto);

    boolean esFavorito(int idUsuario, int idProducto);
}
