package co.edu.uniquindio.unimarket.servicios.interfaces;

public interface FavoritoServicio {

    void crearFavorito(int idUsuario, int idProducto) throws Exception;

    void eliminarFavorito(int idUsuario, int idProducto) throws Exception;


}
