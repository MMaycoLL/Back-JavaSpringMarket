package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DescuentoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDescuentoDTO;
import co.edu.uniquindio.unimarket.entidades.Descuento;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.DescuentoRepo;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaActualIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechaLimiteIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoFechasIncorectaException;
import co.edu.uniquindio.unimarket.servicios.excepciones.descuento.DescuentoNoEncontradoException;
import co.edu.uniquindio.unimarket.servicios.interfaces.DescuentoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class DescuentoServicioImpl implements DescuentoServicio {

    private final DescuentoRepo descuentoRepo;

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

    @Override
    public void eliminarDescuento(int idProducto) throws Exception {
        Descuento descuento = obtener(idProducto);
        descuentoRepo.delete(descuento);
    }


    @Override
    public Descuento obtener(int idDescuento) throws Exception {
        return descuentoRepo.findById(idDescuento).orElseThrow(() -> new DescuentoNoEncontradoException("No se encontró el descuento"));
    }

    @Override
    public List<ProductoDescuentoDTO> obtenerProductosConDescuento() throws Exception {
        // Busca en la base de datos todos los productos que tengan un descuento aplicado
        List<ProductoDescuentoDTO> productosConDescuento = new ArrayList<>();

        // Llama a la consulta JPQL para obtener los descuentos y productos asociados
        List<Object[]> descuentosVigentes = descuentoRepo.findDescuentosVigentes(LocalDate.now());

        // Itera sobre los resultados de la consulta y agrega los productos con descuento a la lista
        for (Object[] resultado : descuentosVigentes) {
            Descuento descuento = (Descuento) resultado[0];
            Producto producto = (Producto) resultado[1];

            ProductoDescuentoDTO productoDescuento = new ProductoDescuentoDTO();
            productoDescuento.setIdProducto(producto.getIdProducto());
            productoDescuento.setNombre(producto.getNombreProducto());
            productoDescuento.setPrecioActual(producto.getPrecioActual());
            productoDescuento.setPorcentajeDescuento(descuento.getPorcentajeDescuento());

            productosConDescuento.add(productoDescuento);
        }

        return productosConDescuento;
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




