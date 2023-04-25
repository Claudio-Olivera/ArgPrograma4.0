
SELECT * FROM empresaqatar2022;
CREATE TABLE Empleado (
  DNI VARCHAR(10) PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  nacionalidad VARCHAR(50) NOT NULL,
  departamento VARCHAR(50) NOT NULL,
  FOREIGN KEY (departamento) REFERENCES Departamento(nombre_depto)
);
SELECT * FROM empleado;
CREATE TABLE Departamento (
  nombre_depto VARCHAR(50) PRIMARY KEY,
  presupuesto DECIMAL(10, 2) NOT NULL
);
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento)
VALUES ('12345678A', 'Juan', 'Pérez', 'Español', 'Logística');
UPDATE empleado SET nacionalidad ='Argetina' WHERE DNI ='4123436';
SELECT * FROM departamento;
SELECT * FROM empleado;

DELETE FROM Empleado WHERE DNI ='''43336''';
INSERT INTO Departamento (nombre_depto, presupuesto)
VALUES ( 'Logística',10000000);
SELECT * FROM Departamento where nombre_depto;
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Ventas', 8000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Marketing', 9000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Finanzas', 11000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Recursos Humanos', 7000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Tecnología', 12000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Desarrollo', 13000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Comunicaciones', 6000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Contabilidad', 10000000);
INSERT INTO Departamento (nombre_depto, presupuesto) VALUES ('Investigación', 11000000);

INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('23456789B', 'Sarah', 'Johnson', 'Estadounidense', 'Recursos Humanos');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('34567890C', 'Ahmed', 'Khan', 'Pakistani', 'Ventas');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('45678901D', 'Maria', 'Silva', 'Brasileña', 'Marketing');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('56789012E', 'Andreas', 'Müller', 'Alemán', 'Finanzas');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('67890123F', 'Chen', 'Wei', 'Chino', 'Logística');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('78901234G', 'Anna', 'Ivanova', 'Rusa', 'Ventas');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('89012345H', 'Hiroshi', 'Tanaka', 'Japonés', 'Recursos Humanos');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('90123456I', 'Katarzyna', 'Nowak', 'Polaca', 'Marketing');
INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES ('01234567J', 'Mohammed', 'Ali', 'Egipcio', 'Finanzas');