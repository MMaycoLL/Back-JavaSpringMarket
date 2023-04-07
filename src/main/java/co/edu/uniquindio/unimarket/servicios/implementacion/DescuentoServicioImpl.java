package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DescuentoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Descuento;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.DescuentoRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
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

    @Override
    public void aplicarDescuento(DescuentoGetDTO descuentoGetDTO) throws Exception {
        // Buscar el producto
        Optional<Producto> productoOptional = productoRepo.findById(descuentoGetDTO.getIdProducto());
        if (productoOptional.isEmpty()) {
            throw new NoSuchElementException("Producto no encontrado");
        }

        Producto producto = productoOptional.get();

        // Verificar que la fecha de fin del descuento sea posterior a la fecha actual
        LocalDate fechaFin = descuentoGetDTO.getFechaFinalDescuento();
        if (LocalDate.now().isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de fin del descuento debe ser posterior a la fecha actual");
        }

        // Aplicar el descuento al precio del producto
        BigDecimal porcentajeDescuentoActual = descuentoGetDTO.getPorcentajeDescuento();
        BigDecimal precioActual = BigDecimal.valueOf(producto.getPrecioActual());
        BigDecimal descuento = porcentajeDescuentoActual.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal precioConDescuento = precioActual.multiply(BigDecimal.ONE.subtract(descuento));
        producto.setPrecioActual(precioConDescuento.floatValue());
        productoRepo.save(producto);
    }

}




