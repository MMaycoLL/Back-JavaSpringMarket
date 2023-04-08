package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;

public interface FavoritoServicio {

    void crearFavorito(FavoritoDTO favoritoDTO) throws Exception;

    void eliminarFavorito(int idUsuario, int idProducto) throws Exception;


}
