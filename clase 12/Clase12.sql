USE empresaqatar2022;
-- 4. Insertar un empleado nuevo en la nómina de trabajo.
INSERT INTO departamento (id,nombre,presupuesto)
VALUES (1,'logistica',30000);
INSERT INTO departamento (id,nombre,presupuesto)
VALUES (2,'sistemas',80000);
INSERT INTO departamento (id,nombre,presupuesto)
VALUES (3,'compras',60000);

INSERT INTO Empleados (DNI, Nombre, Apellido, Nacionalidad, Departamento_ID)
VALUES (24247382, 'Juliana', 'Mendoza', 'Argentina', 1);
INSERT INTO Empleados (DNI, Nombre, Apellido, Nacionalidad, Departamento_ID)
VALUES (23894872, 'Fernando', 'Olivera', 'EEUU', 1);
INSERT INTO Empleados (DNI, Nombre, Apellido, Nacionalidad, Departamento_ID)
VALUES (22734244, 'Francisco', 'Orellana', 'Argentina', 2);
INSERT INTO Empleados (DNI, Nombre, Apellido, Nacionalidad, Departamento_ID)
VALUES (33726523, 'Martina', 'Cala', 'Argentina', 4);
select * from Empleados;
select * from departamento;
-- 5. Modificar la nacionalidad de algún empleado.
UPDATE Empleados SET Nacionalidad = 'Canada'
WHERE DNI = 33247382;
-- 6. Eliminar un departamento.
DELETE FROM departamento WHERE id = 2;
-- 7. Conocer los empleados que trabajan en el departamento de “logística”.
SELECT Empleados.*
FROM Empleados
JOIN Departamento ON Empleados.Departamento_ID = Departamento.id
WHERE Departamento.nombre = 'logistica';
-- 8 Mostrar todos los departamentos ordenados alfabéticamente.
SELECT *
FROM Departamento
ORDER BY nombre ASC;
SELECT *
FROM Empleados
ORDER BY nombre ASC;





