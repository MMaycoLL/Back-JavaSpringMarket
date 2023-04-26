package co.edu.uniquindio.unimarket.servicios.interfaces;

public interface RecuperarContraseniaServicio {

    void linkCambiarContrasenia(String email) throws Exception;

    void cambiarContrasenia(String email,String cedula, String contrasenia) throws Exception;
}
