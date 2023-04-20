package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.DescuentoRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaActualIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaLimiteIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechasIncorectaException;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DescuentoServicioImpl implements DescuentoServicio {

    private final ProductoRepo productoRepo;

    private final DescuentoRepo descuentoRepo;

    private final ProductoServicio productoServicio;


    @Override
    public void aplicarDescuento(DescuentoDTO descuentoDTO) throws Exception {
        // Buscar el producto
        Optional<Producto> productoOptional = productoRepo.findById(descuentoDTO.getIdProducto());
        if (productoOptional.isEmpty()) {
            throw new NoSuchElementException("Producto no encontrado");
        }

        Producto producto = productoOptional.get();

        // Verificar que la fecha de fin del descuento sea posterior a la fecha actual
        LocalDate fechaFin = descuentoDTO.getFechaFinalDescuento();
        if (LocalDate.now().isAfter(fechaFin)) {
            throw new DescuentoFechaActualIncorectaException("La fecha de fin del descuento debe ser posterior a la fecha actual");
        }

        // Verificar que la fecha de fin del descuento no sea mayor que la fecha límite del producto
        LocalDate fechaLimite = descuentoRepo.obtenerFechaLimite(descuentoDTO.getIdProducto());
        if (fechaFin.isAfter(fechaLimite)) {
            throw new DescuentoFechaLimiteIncorectaException("La fecha de fin del descuento debe ser anterior a la fecha límite del producto");
        }

        // Verificar que la fecha de inicio del descuento sea anterior a la fecha final del descuento
        LocalDate fechaInicio = descuentoDTO.getFechaInicioDescuento();
        if (fechaInicio.isAfter(fechaFin)) {
            throw new DescuentoFechasIncorectaException("La fecha de inicio del descuento debe ser anterior a la fecha final del descuento");
        }

        // Aplicar el descuento al precio del producto
        BigDecimal porcentajeDescuentoActual = descuentoDTO.getPorcentajeDescuento();
        BigDecimal precioActual = BigDecimal.valueOf(producto.getPrecioActual());
        BigDecimal descuento = porcentajeDescuentoActual.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal precioConDescuento = precioActual.multiply(BigDecimal.ONE.subtract(descuento));
        producto.setPrecioActual(precioConDescuento.floatValue());
        productoRepo.save(producto);
    }


}




