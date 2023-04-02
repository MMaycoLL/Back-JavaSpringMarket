package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;

public class FavoritoServicioImpl implements FavoritoServicio {

    @Override
    public int crearFavorito(int idUsuario, int idProducto) {
        return 0;

    }

    @Override
    public int eliminarFavorito(int idUsuario, int idProducto) {
        return 0;
    }

    @Override
    public boolean esFavorito(int idUsuario, int idProducto) {
        return false;
    }
}
