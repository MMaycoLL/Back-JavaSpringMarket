package co.edu.uniquindio.unimarket.servicios.excepciones.usuario;

public class UsuarioNoTieneComprasException extends Exception{
    public UsuarioNoTieneComprasException(String mensaje) {
        super(mensaje);
    }
}
