package co.edu.uniquindio.proyecto.servicios.interfaces;

public interface CalificacionServicio {

    int crearCalificacion(int idUsuario, int idProducto, int calificacion);

    int promedioCalificacion(int idProducto);



}
