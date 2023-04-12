package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;

public interface CalificacionServicio {

    int crearCalificacion(CalificacionDTO calificacionDTO) throws Exception;


    float promedioCalificacion(int idProducto);


}
