package org.example;

import dao.DaoDepartamentoImpl;
import dao.DaoEmpleadoImpl;
import interfaces.DaoEmpleado;

import java.sql.*;
import java.util.Objects;

/**
 * 3. Realizar las consultas para:
 * 4. Insertar un empleado nuevo en la nómina de trabajo.
 * 5. Modificar la nacionalidad de algún empleado.
 * 6. Eliminar un departamento.
 * 7. Conocer los empleados que trabajan en el departamento de “logística” (puede ser
 * cualquiera de los que agreguen).
 * 8. Mostrar todos los departamentos ordenados alfabéticamente.
 **/

public class Main {
    public static void main(String[] args) throws Exception {
        Empleado empleado = new Empleado();
        Departamento departamento = new Departamento();


       /* 4. Insertar un empleado nuevo en la nómina de trabajo.
        empleado.setDNI("2987389743");
        empleado.setNombre("Jorge");
        empleado.setApellido("Salamanca");
        empleado.setDepartamento("Ventas");
        empleado.setNacionalidad("Fraces");*/


        try {
            //  DaoEmpleado daoemple = new DaoEmpleadoImpl();
            // DaoDepartamentoImpl daos = new DaoDepartamentoImpl();
            //   daoemple.registrar(empleado);
            //5Modificar la nacionalidad de algún empleado.

            /** empleado.setDNI("'4123436'");
             empleado.setNacionalidad("China");
             daoemple.modificar(empleado);**/


            // 6. Eliminar un departamento.
            // departamento.setNombre_depto("Investigación");
            //daos.eliminar(departamento);


            //7. Conocer los empleados que trabajan en el departamento de “logística” (puede ser
            //        * cualquiera de los que agreguen).

            /**    for (Empleado e : daoemple.listar()) {
             if (Objects.equals(e.getDepartamento(), "Logística")) {
             System.out.println("Nombre: " + e.getNombre());
             System.out.println("Departamento: " + e.getDepartamento());
             }
             }**/


            //   * 8. Mostrar todos los departamentos ordenados alfabéticamente.
            //  for (Departamento dep : daos.alfabeticamente()) {
            //     System.out.println("Nombre departamento: " + dep.getNombre_depto());

            //     System.out.println("----------");
            //   }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
