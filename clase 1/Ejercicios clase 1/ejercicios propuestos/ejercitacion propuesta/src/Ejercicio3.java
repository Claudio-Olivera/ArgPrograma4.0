public class Ejercicio3 {
    public static void main(String[] args) {
        /**
         * Desarrolle un algoritmo que realice la sumatoria de los números enteros comprendidos
         * entre el 1 y el 10, es decir, 1 + 2 + 3 + …. + 10.
         */
        int suma = 0;
        for (int i = 0; i <= 10; i++) {
            suma += i;
        }
        System.out.println(suma);
    }
}
