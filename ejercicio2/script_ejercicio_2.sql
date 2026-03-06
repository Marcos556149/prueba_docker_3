

CREATE SEQUENCE ejercicio_2.duenio_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE ejercicio_2.mascota_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE ejercicio_2.duenio(
	id_duenio BIGINT DEFAULT nextval('ejercicio_2.duenio_seq'),
	dni varchar(100),
	nombre_duenio varchar(100),
	apellido varchar(100),
	celular varchar(100),
	CONSTRAINT pk_duenio
		PRIMARY KEY(id_duenio)
);

CREATE TABLE ejercicio_2.mascota(
	id_mascota BIGINT DEFAULT nextval('ejercicio_2.mascota_seq'),
	nombre_mascota varchar(100),
	especie varchar(100),
	raza varchar(100),
	color varchar(100),
	id_duenio BIGINT,
	CONSTRAINT pk_mascota
		PRIMARY KEY(id_mascota),
	CONSTRAINT fk_mascota_duenio
		FOREIGN KEY(id_duenio)
		REFERENCES ejercicio_2.duenio(id_duenio)
		ON UPDATE CASCADE
		ON DELETE SET NULL
);
