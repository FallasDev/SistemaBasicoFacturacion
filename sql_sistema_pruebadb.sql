DROP DATABASE IF EXISTS db_limpiezaJuan;
CREATE DATABASE IF NOT EXISTS db_limpiezaJuan;

USE db_limpiezaJuan; 


CREATE TABLE Productos(
	id_producto int auto_increment primary key,
    nombre varchar(150),
    precio int,
    descripcion varchar(300)
);

CREATE TABLE Clientes(
	id_cliente int auto_increment primary key,
    nombre varchar(150),
    apellidos varchar(300),
    direccion varchar(400),
    telefono varchar(12),
    correo_electronico varchar(80)
);

/* CREATE TABLE Configuracion (
	id_configuracion int auto_increment primary key,
	nombre_empresa varchar(150),
    correo_empresa varchar(80),
    telefono_empresa varchar(12),
    direccion varchar(400)
); */

CREATE TABLE Facturas(
	id_factura int auto_increment primary key,
    id_cliente int,
    id_configuracion int DEFAULT 1,
    total int,
    foreign key (id_cliente) references Clientes(id_cliente)
);

CREATE TABLE Detalles(
	id_detalle int auto_increment primary key,
    id_producto int,
    id_factura int,
    cantidad int,
    foreign key (id_producto) references Productos(id_producto),
    foreign key (id_factura) references Facturas(id_factura)
	on delete cascade on update cascade 
);