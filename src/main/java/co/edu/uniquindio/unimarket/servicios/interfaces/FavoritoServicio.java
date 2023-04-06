package co.edu.uniquindio.unimarket.servicios.interfaces;

public interface FavoritoServicio {

    void crearFavorito(int idUsuario, int idProducto) throws Exception;

    int eliminarFavorito(int idUsuario, int idProducto) throws Exception;


}
