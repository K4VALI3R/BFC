CREATE DATABASE bfc;
USE bfc;

CREATE TABLE producto
(
    productoId INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(30)   NOT NULL,
    imagen     VARCHAR(255)  NOT NULL,
    precio     DECIMAL(5, 2) NOT NULL,
    categoria  VARCHAR(20)   NOT NULL
);

CREATE TABLE combo
(
    comboId   INT AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(30)   NOT NULL,
    imagen    VARCHAR(255)  NOT NULL,
    precio    DECIMAL(5, 2) NOT NULL,
    categoria VARCHAR(20)   NOT NULL
);

CREATE TABLE cliente
(
    clienteId      INT AUTO_INCREMENT PRIMARY KEY,
    nombreCompleto VARCHAR(50)  NOT NULL,
    numeroTelefono VARCHAR(15)  NOT NULL,
    correo         VARCHAR(50)  NOT NULL,
    contrasena     VARCHAR(255) NOT NULL
);

CREATE TABLE admin
(
    adminId        INT AUTO_INCREMENT PRIMARY KEY,
    nombreCompleto VARCHAR(50)  NOT NULL,
    correo         VARCHAR(50)  NOT NULL,
    contrasena     VARCHAR(255) NOT NULL,
    tipo           VARCHAR(20)  NOT NULL
);

CREATE TABLE productoCombo
(
    productoComboId INT AUTO_INCREMENT PRIMARY KEY,
    comboId         INT REFERENCES combo (comboId),
    productoId      INT REFERENCES producto (productoId)
);

CREATE TABLE pedido
(
    pedidoId  INT AUTO_INCREMENT PRIMARY KEY,
    clienteId INT REFERENCES cliente (clienteId),
    adminId   INT REFERENCES admin (adminId),
    fecha     DATETIME DEFAULT CURRENT_TIMESTAMP,
    direccion VARCHAR(40)   NOT NULL,
    monto     DECIMAL(6, 2) NOT NULL,
    estado    VARCHAR(15)   NOT NULL
);

CREATE TABLE pedidoDetalle
(
    pedidoDetalleId INT AUTO_INCREMENT PRIMARY KEY,
    pedidoId        INT REFERENCES pedido (pedidoId),
    productoId      INT,
    comboId         INT,
    cantidad        INT           NOT NULL,
    subtotal        DECIMAL(6, 2) NOT NULL,

    FOREIGN KEY (productoId) REFERENCES producto (productoId),
    FOREIGN KEY (comboId) REFERENCES combo (comboId),
    CHECK (
        (productoId IS NOT NULL AND comboId IS NULL)
            OR
        (productoId IS NULL AND comboId IS NOT NULL)
        )
);

CREATE TABLE proveedor
(
    proveedorId     INT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(50)  NOT NULL,
    ruc             VARCHAR(20)  NOT NULL,
    direccion       VARCHAR(100) NOT NULL,
    telefono        VARCHAR(15)  NOT NULL,
    correo          VARCHAR(50)  NOT NULL,
    personaContacto VARCHAR(50)  NOT NULL
);

CREATE TABLE ingreso
(
    ingresoId     INT AUTO_INCREMENT PRIMARY KEY,
    productoId    INT REFERENCES producto (productoId),
    proveedorId   INT REFERENCES proveedor (proveedorId),
    cantidad      INT NOT NULL,
    fecha         DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE inventario
(
    inventarioId INT AUTO_INCREMENT PRIMARY KEY,
    productoId   INT REFERENCES producto (productoId),
    stock        INT NOT NULL
)