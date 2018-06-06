CREATE TABLE animales (
    chip   STRING      PRIMARY KEY,
    nombre STRING,
    edad   INTEGER (3),
    sexo   STRING (1)  CONSTRAINT SEXO_CHK CHECK (UPPER(SEXO) IN ('M', 'F') ),
    dueño  STRING (9) 
);

CREATE TABLE clientes (
    dni       STRING (9) PRIMARY KEY CONSTRAINT DNI_CHK CHECK (LENGTH(dni) = 9 ),
    nombre    STRING     NOT NULL,
    apellidos STRING     NOT NULL,
    telefono  STRING (9),
    direccion STRING,
    email     STRING
);

CREATE TABLE empleados (
    dni       STRING (9) PRIMARY KEY CONSTRAINT DNI_CHK CHECK (LENGTH(dni) = 9 ),
    nombre    STRING     NOT NULL,
    apellidos STRING     NOT NULL,
    telefono  STRING (9),
    sueldo    DOUBLE     DEFAULT 600,
    tipo      STRING     CONSTRAINT TIPO_CHK CHECK (UPPER(TIPO) IN ('VETERINARIO', 'ADMINISTRATIVO', 'AUXILIAR', 'RECEPCIONISTA') ) 
);
