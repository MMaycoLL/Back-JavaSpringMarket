
# JavaSpringMarket

JavaSpringMarket es una tienda en línea que permite a los usuarios comprar y vender productos de diversas categorías. Este proyecto se ha desarrollado utilizando Spring Boot y se ha utilizado Gradle como herramienta de construcción y Hibernate para la base de datos con MySQL. Además, se ha utilizado Java 17 para el desarrollo del proyecto.

## Funcionalidades
### Usuario
- Registrarse y loguearse.
- Publicar un producto para vender.
- Comentar en un producto.
- Guardar productos en su lista de favoritos y quitar productos de dicha lista.
- Comprar uno o varios productos. Este proceso requiere un carrito de compra.
- Cambiar su contraseña por medio de un link enviado a su correo electrónico en caso de olvido.
- Buscar productos por nombre y/o precio.
- Listar sus propias compras.
- Listar sus propios productos, eliminarlos o actualizarlos.
- Listar sus propios favoritos.
### Moderador
- Loguearse.
- Autorizar o prohibir productos.
- Ver la lista de todos los productos según el estado (sin revisar, autorizados y denegados).

## Información requerida
### Usuario
- Nombre completo.
- Email.
- Cédula.
- Número de teléfono.
- Dirección.
- Contraseña.
### Producto
- Al menos una imagen.
- Un nombre.
- Una descripción.
- Un precio.
- Una disponibilidad.
- Fecha límite.
- Categorías.
- Comentarios.
### Compra
- Cliente.
- Producto/s.
- Fecha.
- Total de la compra.
- Método de pago.
### Otros detalles
- La página de inicio muestra los productos de manera organizada y permite listarlos por categorías.
- La página de detalle muestra toda la información del producto, incluyendo sus imágenes. Solo los usuarios logueados pueden ver la lista de comentarios, marcar como favorito o agregar al carrito.
- Para poder mostrar un producto en la página, se valida que no se haya superado la fecha límite.
- Se utiliza un servicio de terceros (por ejemplo, Cloudinary, Firebase, Flickr) para el manejo de imágenes.
- Los moderadores están precargados en la base de datos.
- Se envía un correo electrónico cada vez que se realiza una compra, tanto al comprador como al vendedor, con los detalles de la misma.
- Se envía un correo electrónico al usuario que publicó el producto cada vez que alguien deja un comentario en uno de sus productos.
- Se envía un correo electrónico al vendedor cada vez que su producto es aprobado o prohibido por un moderador.
## Ejecución del proyecto
Para ejecutar el proyecto, sigue estos pasos:

- Descarga el repositorio de GitHub.
- Abre el proyecto en tu IDE preferido.
- Configura la conexión a la base de datos en el archivo application.properties.
- Ejecuta la aplicación.

