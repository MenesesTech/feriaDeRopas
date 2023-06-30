CREATE SCHEMA `presupuestoferiasbd`;

USE `presupuestoferiasbd`;

CREATE TABLE empleado (
    id VARCHAR(50) PRIMARY KEY NOT NULL,
    username VARCHAR(50),
    password VARCHAR(50),
    name VARCHAR(50),
    lastName VARCHAR(50),
    DNI VARCHAR(50),
    district VARCHAR(50),
    email VARCHAR(50),
    telephone VARCHAR(50),
    rol VARCHAR(50),
    created DATETIME,
    updated DATETIME
);

CREATE TABLE feria (
    id_feria VARCHAR(50) PRIMARY KEY NOT NULL,
    name VARCHAR(60),
    district VARCHAR(60),
    aforo INT,
    category VARCHAR(60),
    status VARCHAR(60),
    monto DECIMAL(10,2),
    fecha_inicio DATE,
    fecha_final DATE
);

CREATE TABLE egreso (
    cod_egreso VARCHAR(50) PRIMARY KEY NOT NULL,
    tipo VARCHAR(60),
    categoria VARCHAR(60),
    product_serv VARCHAR(300),
    cantidad INT,
    precio DECIMAL(10,2),
    id_feria VARCHAR(50),
    FOREIGN KEY (id_feria) REFERENCES feria (id_feria)
);

CREATE TABLE ingreso (
    cod_ingreso VARCHAR(50) PRIMARY KEY NOT NULL,
    tipo VARCHAR(60),
    categoria VARCHAR(60),
    product_serv VARCHAR(300),
    cantidad INT,
    precio DECIMAL(10,2),
    id_feria VARCHAR(50),
    FOREIGN KEY (id_feria) REFERENCES feria (id_feria)
);
