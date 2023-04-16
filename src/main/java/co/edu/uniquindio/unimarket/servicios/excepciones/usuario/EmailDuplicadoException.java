package co.edu.uniquindio.unimarket.servicios.excepciones.usuario;

public class EmailDuplicadoException extends Exception {
    public EmailDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
