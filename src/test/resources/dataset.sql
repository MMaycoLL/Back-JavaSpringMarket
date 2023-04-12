insert into usuario
values
    -- id, contraseña, cedula, email, nombre_completo, direccion, telefono

    (1, "123451", "111641", "pepe1@gmail.com", "pepito perez", "calle 54 # 11-21", "31238521"),
    (2, "123452", "111642", "juan1@gmail.com", "juan perez", "calle 52 # 12-22", "31238522"),
    (3, "123453", "111643", "carlos1@gmail.com", "carlos perez", "calle 51 # 13-23", "31238523"),
    (4, "123454", "111644", "andres1@gmail.com", "andres perez", "calle 55 # 14-24", "31238524"),
    (5, "123455", "111645", "julio1@gmail.com", "julio perez", "calle 56 # 15-25", "31238525"),
    (6, "123456", "111646", "alexis1@gmail.com", "alexis perez", "calle 57 # 16-26", "31238526");


insert into moderador
values
    -- id, contraseña, cedula, email, nombre_completo

    (7, "123457", "111647", "camilo1@gmail.com", "camilo perez"),
    (8, "123458", "111648", "andrea1@gmail.com", "andrea perez"),
    (9, "123459", "111649", "juliana1@gmail.com", "juliana perez"),
    (10, "1234510", "1116410", "mariana1@gmail.com", "mariana perez"),
    (11, "1234511", "1116411", "tatiana1@gmail.com", "tatiana perez"),
    (12, "1234512", "1116412", "yuliana1@gmail.com", "yuliana perez");


insert into producto
values
    -- id, descripcion, estado, fecha_creacion, fecha_limite, nombre, precio, stock, id_persona

    (1, "descripcion  producto 1", "ACTIVO", "2023-04-05 14:37:12", "2023-6-05 14:37:12", "balon", 50000, 10, 1),
    (2, "descripcion  producto 2", "ACTIVO", "2023-04-05 14:37:12", "2023-6-05 14:37:12", "balon", 60000, 11, 2),
    (3, "descripcion  producto 1", "INACTIVO", "2023-04-05 14:37:12", "2023-6-05 14:37:12", "balon", 70000, 12, 3),
    (4, "descripcion  producto 4", "ACTIVO", "2023-04-05 14:37:12", "2023-6-05 14:37:12", "libro1", 80000, 13, 4),
    (5, "descripcion  producto 5", "ACTIVO", "2023-04-05 14:37:12", "2023-6-05 14:37:12", "CD", 90000, 14, 5),
    (6, "descripcion  producto 6", "ACTIVO", "2023-04-05 14:37:12", "2023-6-05 14:37:12", "celular", 50000, 15, 6);


insert into envio
values
    -- id, ciudadEnvio, direccionDestinatario, nombreDestinatario, telefonoDestinatario, idUsuario

    (1, "CARTAGENA", "calle 54 # 11-21", "pepito perez", "31238521", 1),
    (2, "PEREIRA", "calle 52 # 12-22", "juan perez", "31238522", 2),
    (3, "MANIZALES", "calle 51 # 13-23", "carlos perez", "31238523", 3),
    (4, "ARMENIA", "calle 55 # 14-24", "andres perez", "31238524", 4),
    (5, "CUCUTA", "calle 56 # 15-25", "julio perez", "31238525", 5),
    (6, "IBAGUE", "calle 57 # 16-26", "alexis perez", "31238526", 6);


insert into compra
values
    -- id, fecha, metodo_pago, total_compra, id_envio, id_persona

    (1, "2023-04-05 14:37:12", "TARJETA_CREDITO", 100000, 1, 2),
    (2, "2023-04-05 14:37:12", "TARJETA_DEBITO", 110000, 2, 2),
    (3, "2023-04-05 14:37:12", "PAYPAL", 120000, 3, 3),
    (4, "2023-04-05 14:37:12", "EFECTIVO", 130000, 4, 4),
    (5, "2023-04-05 14:37:12", "TARJETA_DEBITO", 140000, 5, 5),
    (6, "2023-04-05 14:37:12", "TARJETA_CREDITO", 150000, 6, 6);


insert into producto_moderador
values
    -- id, estado,fecha, descripcion, id_moderador, id_producto

    (1, "DENEGADO", "2023-04-05 14:37:12", "se denega por falta de descripcion", 7, 1),
    (2, "AUTORIZADO", "2023-04-05 14:37:12", "se autoriza", 8, 2),
    (3, "SIN_REVISAR", "2023-04-05 14:37:12", "no se revisa aun", 9, 3),
    (4, "DENEGADOS", "2023-04-05 14:37:12", "se denega por falta de descripcion", 10, 4),
    (5, "AUTORIZADO", "2023-04-05 14:37:12", "se autoriza", 11, 5),
    (6, "SIN_REVISAR", "2023-04-05 14:37:12", "no se revisa_aun", 12, 6);


insert into producto_imagen
values
    -- id, nombre, url

    (1, "img1", "https://www.google.com/imagen1.jpg"),
    (2, "img2", "https://www.google.com/imagen2.jpg"),
    (3, "img3", "https://www.google.com/imagen3.jpg"),
    (4, "img4", "https://www.google.com/imagen4.jpg"),
    (5, "img5", "https://www.google.com/imagen5.jpg"),
    (6, "img6", "https://www.google.com/imagen6.jpg");


insert into detalle_compra
values
    -- id, cantidad, precio, id_compra, id_producto

    (1, 20, 50000, 2, 1),
    (2, 20, 60000, 1, 2),
    (3, 20, 70000, 5, 3),
    (4, 20, 80000, 4, 4),
    (5, 20, 90000, 5, 5),
    (6, 20, 100000, 6, 6);


insert into producto_categorias
values
    -- id, categoria

    (1, "HOGAR"),
    (2, "HOGAR"),
    (3, "DEPORTE"),
    (4, "LIBROS"),
    (5, "MUSICA"),
    (6, "TECNOLOGIA");


insert into favorito
values
    -- id, fecha_agregado, id_producto, id_persona

    (1, "2023-04-05 14:37:12", 1, 1),
    (2, "2023-04-05 14:37:12", 2, 1),
    (3, "2023-04-05 14:37:12", 3, 3),
    (4, "2023-04-05 14:37:12", 4, 4),
    (5, "2023-04-05 14:37:12", 5, 5),
    (6, "2023-04-05 14:37:12", 6, 6);


insert into descuento
values
    -- id, fecha_inicio, fecha_fin, porcentaje, id_producto

    (1, "2023-04-07", "2023-05-05", 10, 1),
    (2, "2023-04-05", "2023-05-05", 20, 2),
    (3, "2023-04-05", "2023-05-05", 30, 3),
    (4, "2023-04-05", "2023-05-05", 40, 4),
    (5, "2023-04-05", "2023-05-05", 50, 5),
    (6, "2023-04-05", "2023-05-05", 60, 6);


insert into comentario
values
    -- id, comentario, fecha, id_producto, id_persona

    (1, "comentario 1", "2023-04-05 14:37:12", 1, 1),
    (2, "comentario 2", "2023-04-05 14:37:12", 2, 2),
    (3, "comentario 3", "2023-04-05 14:37:12", 3, 3),
    (4, "comentario 4", "2023-04-05 14:37:12", 4, 4),
    (5, "comentario 5", "2023-04-05 14:37:12", 5, 5),
    (6, "comentario 6", "2023-04-05 14:37:12", 6, 6);


insert into calificacion
values
    -- id, comentario_calificacion, valor_calificacion, id_producto_compra, id_persona

    (1, "comentario calificacion 1", 1, 1, 1),
    (2, "comentario calificacion 2", 5, 2, 2),
    (3, "comentario calificacion 3", 3, 2, 2),
    (4, "comentario calificacion 4", 5, 2, 2),
    (5, "comentario calificacion 5", 5, 2, 2),
    (6, "comentario calificacion 6", 6, 6, 6);