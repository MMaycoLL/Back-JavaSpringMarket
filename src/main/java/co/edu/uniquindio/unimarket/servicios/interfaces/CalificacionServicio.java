package co.edu.uniquindio.unimarket.servicios.interfaces;

public interface CalificacionServicio {

    int crearCalificacion(int idUsuario, int idProducto, int calificacion);

    int promedioCalificacion(int idProducto);



}
