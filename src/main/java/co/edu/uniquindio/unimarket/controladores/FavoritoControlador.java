package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favoritos")
@AllArgsConstructor
public class FavoritoControlador {

    private final FavoritoServicio favoritoServicio;

    public void crearFavorito(FavoritoDTO favoritoDTO) throws Exception {

    }

    public void eliminarFavorito(int idUsuario, int idProducto) throws Exception {

    }


}
