PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

CREATE TABLE animales (
    chip   STRING      PRIMARY KEY,
    nombre STRING,
    edad   INTEGER (3),
    sexo   STRING (1)  CONSTRAINT SEXO_CHK CHECK (UPPER(SEXO) IN ('M', 'F') ),
    dueño  STRING (9) 
);

CREATE TABLE clientes (
    dni       STRING (9)  PRIMARY KEY,
    nombre    STRING      NOT NULL,
    apellidos STRING      NOT NULL,
    telefono  INTEGER (9),
    localidad STRING,
    email     STRING
);

CREATE TABLE empleados (
    DNI       STRING PRIMARY KEY,
    Nombre    STRING NOT NULL,
    Apellidos STRING NOT NULL,
    tipo      STRING NOT NULL
);

CREATE TABLE tipoempleados (
    Empleo      STRING PRIMARY KEY,
    Descripción STRING
);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;