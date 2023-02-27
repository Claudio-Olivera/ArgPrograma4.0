public class Main {
    public static void main(String[] args) {

        /**
         * Punto a:
         * Las variables de entrada serian:
         *
         * 1-variable de tipo double o float para representar los ingresos Mensuales iguales o mayores a $489.083
         *
         * 2-variable de tipo integer para representar la cantidad de vehículos igual o mayor a 3,con la condición de que sean de una antigüedad menor a 5 años
         *
         * 3- variable de tipo integer para representar la cantidad de años de vehículos
         *
         * 4-variable de tipo integer para representar la cantidad de inmuebles igual o mayor a 3
         *
         * 5-variable de tipo booleano para representar si cumple alguna de las siguientes características:
         * Poseer una embarcación, una aeronave de lujo o ser titular de activos
         * societarios que demuestren capacidad económica plena.
         *
         */

        /**
         * Punto b:
         *
         *  Entrada: Ingresos, vehículos, antigüedad de los vehículos, inmuebles, (embarcación, aeronave o
         *  activos societarios que demuestren capacidad económica plena)
         *  Salida: Pertenece a segmento de altos ingresos o no
         *
         */

        /**
         * Punto c:
         * Abrir el archivo pdf incluido: ejercicio 2 punto c.pdf
         */

        /**
         * Punto d:
         *
         * Nota: Se tendría que mejorar el nombre de las variables utilizadas, en este caso son extensos para representar claramente a que se refieren,
         * también se podría usar scanner para pedir al usuario los datos que usan las variables.
         *
         */
        double ingresosMensuales = 400000;
        int cantidadDeVehiculos = 3;
        int antiguedadVehiculo = 10;
        int cantidadDeInmuebles = 2;
        boolean poseeEmbarcacionesAeronavesBienesSocietarios = false;

       if (ingresosMensuales >= 489083 || cantidadDeInmuebles >= 3 || (cantidadDeVehiculos>=3 && antiguedadVehiculo <=5) || poseeEmbarcacionesAeronavesBienesSocietarios ){
           System.out.println( "Pertenece al segmento de altos ingresos" );
       }else{
           System.out.println("No pertenece al segmento de altos ingresos");
       }

    }
}