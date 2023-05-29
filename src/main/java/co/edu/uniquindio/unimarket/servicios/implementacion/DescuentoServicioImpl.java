package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaActualIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaLimiteIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechasIncorectaException;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@AllArgsConstructor
public class DescuentoServicioImpl implements DescuentoServicio {

    private final ProductoServicio productoServicio;


    @Override
    public void aplicarDescuento(DescuentoDTO descuentoDTO) throws Exception {
        // Buscar el producto
        Producto producto = productoServicio.obtener(descuentoDTO.getIdProducto());

        // Verificar que la fecha de fin del descuento sea posterior a la fecha actual
        validarFechaFinDescuento(descuentoDTO.getFechaFinalDescuento(), descuentoDTO.getFechaInicioDescuento());

        // Verificar que la fecha de inicio del descuento sea anterior a la fecha final del descuento
        validarFechaInicioDescuento(descuentoDTO.getFechaInicioDescuento());

        // Aplicar el descuento al precio del producto
        float precioActual = producto.getPrecioActual();
        float porcentajeDescuentoActual = descuentoDTO.getPorcentajeDescuento();
        float precioConDescuento = precioActual * (1 - (porcentajeDescuentoActual / 100));

        producto.setPrecioActual(precioConDescuento);

        productoServicio.actualizarPrecio(producto.getIdProducto(), producto.getPrecioActual());
    }

    private void validarFechaInicioDescuento(LocalDate fechaInicioDescuento) throws Exception {
        LocalDate fechaInicio = LocalDate.now();
        if (fechaInicioDescuento.isBefore(fechaInicio)) {
            throw new DescuentoFechasIncorectaException("La fecha de inicio del descuento debe ser posterior a la fecha actual");
        }
    }

    private void validarFechaFinDescuento(LocalDate fechaFinalDescuento, LocalDate fechaInicioDescuento) throws Exception {
        LocalDate fechaFin = LocalDate.now();
        if (fechaFinalDescuento.isBefore(fechaFin)) {
            throw new DescuentoFechaActualIncorectaException("La fecha de fin del descuento debe ser posterior a la fecha actual");
        }
        if (fechaFinalDescuento.isBefore(fechaInicioDescuento)) {
            throw new DescuentoFechaLimiteIncorectaException("La fecha de fin del descuento debe ser posterior a la fecha de inicio del descuento");
        }

    }
}




