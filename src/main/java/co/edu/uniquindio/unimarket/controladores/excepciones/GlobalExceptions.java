package co.edu.uniquindio.unimarket.controladores.excepciones;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.excepciones.calificacion.PermisoDenegadoCalificacionException;
import co.edu.uniquindio.unimarket.servicios.excepciones.comentario.ComentaiosVaciosException;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.CompraNoEncontradaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.DetalleCompraNotFoundException;
import co.edu.uniquindio.unimarket.servicios.excepciones.compra.UnidadesNoDisponiblesException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaActualIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaLimiteIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechasIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.envio.EnvioNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.favorito.FavoritoNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.favorito.ProductoYaFavoritoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.moderador.ModeradorNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.producto.PermisoDenegadoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.producto.ProductoNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.excepciones.producto.SinProductosFavoritosException;
import co.edu.uniquindio.unimarket.servicios.excepciones.usuario.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.print.AttributeException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<MensajeDTO> badCredentialsException(BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                MensajeDTO(HttpStatus.BAD_REQUEST, true, "Datos de autenticación incorrectos"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeDTO> generalException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new
                MensajeDTO(HttpStatus.INTERNAL_SERVER_ERROR, true, e.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<MensajeDTO> accessDeniedException(AccessDeniedException
                                                                    accessDeniedException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new
                MensajeDTO(HttpStatus.FORBIDDEN, true, "No se puede acceder a este recurso"));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeDTO> validationException(MethodArgumentNotValidException ex) {
        List<String> messages = new ArrayList<>();
        BindingResult results = ex.getBindingResult();
        for (FieldError e : results.getFieldErrors()) {
            messages.add(e.getField() + ": " + e.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                messages.toString()));
    }

    // Excepciones propias
    @ExceptionHandler(PermisoDenegadoCalificacionException.class)
    public ResponseEntity<MensajeDTO> throwAttributeException(AttributeException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(ComentaiosVaciosException.class)
    public ResponseEntity<MensajeDTO> throwComentariosVaciosException(ComentaiosVaciosException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(CompraNoEncontradaException.class)
    public ResponseEntity<MensajeDTO> throwCompraNoEncontradaException(CompraNoEncontradaException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(DetalleCompraNotFoundException.class)
    public ResponseEntity<MensajeDTO> throwDetalleCompraNotFoundException(DetalleCompraNotFoundException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(UnidadesNoDisponiblesException.class)
    public ResponseEntity<MensajeDTO> throwUnidadesNoDisponiblesException(UnidadesNoDisponiblesException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(DescuentoFechaActualIncorectaException.class)
    public ResponseEntity<MensajeDTO> throwDescuentoFechaActualIncorectaException(DescuentoFechaActualIncorectaException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(DescuentoFechaLimiteIncorectaException.class)
    public ResponseEntity<MensajeDTO> throwDescuentoFechaLimiteIncorectaException(DescuentoFechaLimiteIncorectaException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(DescuentoFechasIncorectaException.class)
    public ResponseEntity<MensajeDTO> throwDescuentoFechaActualIncorectaException(DescuentoFechasIncorectaException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(DescuentoNoEncontradoException.class)
    public ResponseEntity<MensajeDTO> throwDescuentoNoEncontradoException(DescuentoNoEncontradoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(EnvioNoEncontradoException.class)
    public ResponseEntity<MensajeDTO> throwEnvioNoEncontradoException(EnvioNoEncontradoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(FavoritoNoEncontradoException.class)
    public ResponseEntity<MensajeDTO> throwFavoritoNoEncontradoException(FavoritoNoEncontradoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(ProductoYaFavoritoException.class)
    public ResponseEntity<MensajeDTO> throwProductoYaFavoritoException(ProductoYaFavoritoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(ModeradorNoEncontradoException.class)
    public ResponseEntity<MensajeDTO> throwModeradorNoEncontradoException(ModeradorNoEncontradoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(PermisoDenegadoException.class)
    public ResponseEntity<MensajeDTO> throwPermisoDenegadoException(PermisoDenegadoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<MensajeDTO> throwProductoNoEncontradoException(ProductoNoEncontradoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(SinProductosFavoritosException.class)
    public ResponseEntity<MensajeDTO> throwSinProductosFavoritosException(SinProductosFavoritosException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(CedulaNoCoincideConUsuarioException.class)
    public ResponseEntity<MensajeDTO> throwCedulaNoCoincideConUsuarioException(CedulaNoCoincideConUsuarioException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(CedulaDuplicadaException.class)
    public ResponseEntity<MensajeDTO> throwCedulaDuplicadaException(CedulaDuplicadaException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(CodigoInexistenteException.class)
    public ResponseEntity<MensajeDTO> throwCodigoInexistenteException(CodigoInexistenteException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }

    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<MensajeDTO> throwEmailDuplicadoException(EmailDuplicadoException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getMessage()));
    }

    @ExceptionHandler(ContraseniaUsuarioNoCoincideException.class)
    public ResponseEntity<MensajeDTO> throwContraseniaUsuarioNoCoincideException(ContraseniaUsuarioNoCoincideException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }


    @ExceptionHandler(UsuarioNoTieneComprasException.class)
    public ResponseEntity<MensajeDTO> throwUsuarioNoTieneComprasException(UsuarioNoTieneComprasException e) {
        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
                e.getClass()));
    }


}
