import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {

        /**
         * Array y String
         * 1. Utilizando solo tipos primitivos, String (solo usar método length), vectores,
         * iteraciones simples y condicionales, genere una clase por ejercicio que posea los
         * siguientes métodos:
         * a. Dado un String y una letra, que cuente la cantidad de apariciones de la letra en
         * el String
         * b. Dados 3 números y un orden (ascendente o decreciente) que ordene los
         * mismos y los retorne en un vector de 3
         * c. dado un vector de números, y un número X, que sume todos los números > X y
         * retorne el resultado
         */


        /**
         * Ejercicio 1 - a
         */
        String palabra = "perro";
        char letra = 'r';
        /*LLamada al método y paso por parámetro de las variables palabra y letra*/
        contadorDeLetra(palabra, letra);
        /**
         * Ejercicio 1 - b (para este ejercicio cree 2 posibles soluciones una utiliza .sort y la otra no)
         */
        int num1 = 20;
        int num2 = 10;
        int num3 = 30;
        String orden = "ascendente";
        int [] resultado = ordenarNumeros(num1,num2,num3,orden);

        int [] resultadoSinSort = ordenarNumerosSinSort(num1,num2,num3,orden);
        /*Hago import de Arrays de java util para poder hacer uso de .sort y .toString*/
        System.out.println("Para este resultado se usa la funcion ordenarNumeros "+Arrays.toString(resultado));
        System.out.println("Para este resultado se usa la funcion ordenarNumerosSinSort "+Arrays.toString(resultadoSinSort));
        /**
         * Ejercicio 1 - c
         */
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        int x = 8;
        int resultadoSuma = sumarMayores(numeros,x);
        System.out.println("La suma de los números mayores a "+x+" es "+resultadoSuma);

    }

    /**
     * Para ejercicio 1 - a
     * @param palabra
     * @param letra
     */
        private static void contadorDeLetra (String palabra,char letra){
            int contador = 0;
            for (int i = 0; i < palabra.length(); i++) {
                /*Comparo si la letra esta en esa posicion del string, pasandole al metodo charAt el valor de i*/
                if (letra == palabra.charAt(i)) {
                    contador+=1;
                }
            }
            System.out.println("La cantidad de veces que se repite "+letra+" en el array es: "+contador);
        }

    /**
     * Primera respuesta para ejercicio 1 - b
     * @param num1
     * @param num2
     * @param num3
     * @param orden
     * @return
     */

        private static int[] ordenarNumeros (int num1, int num2, int num3, String orden) {
            int[] arrnumeros = {num1, num2, num3};

            Arrays.sort(arrnumeros);
            if (orden.equals("decreciente")) {
                int[] numerosDecrecientes = new int[arrnumeros.length];
                for (int i = 0; i < arrnumeros.length; i++) {
                    numerosDecrecientes[i] = arrnumeros[arrnumeros.length - 1 - i];
                }
                return numerosDecrecientes;
            }
                return arrnumeros;
        }

    /**
     * Segunda respuesta para Ejercicio 1 - b (Ahora sin uso de sort)
     * @param num1
     * @param num2
     * @param num3
     * @param orden
     * @return
     */
    public static int[] ordenarNumerosSinSort(int num1, int num2, int num3, String orden) {
        int[] arrNumeros = {num1, num2, num3};

        // Ordenar descendente
        for (int i = 0; i < arrNumeros.length - 1; i++) {
            for (int j = i + 1; j < arrNumeros.length; j++) {
                if (arrNumeros[j] > arrNumeros[i]) {
                    int temp = arrNumeros[j];
                    arrNumeros[j] = arrNumeros[i];
                    arrNumeros[i] = temp;
                }
            }
        }

        // Si es ascendente, invertir el arreglo
        if (orden == "ascendente") {
            for (int i = 0; i < arrNumeros.length / 2; i++) {
                int temp = arrNumeros[i];
                arrNumeros[i] = arrNumeros[arrNumeros.length - 1 - i];
                arrNumeros[arrNumeros.length - 1 - i] = temp;
            }
        }

        return arrNumeros;
    }

    /**
     * Respuesta para Ejercicio 1 - c
     * @param numeros
     * @param x
     * @return
     */
    public static int sumarMayores(int[] numeros, int x) {
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > x) {
                suma += numeros[i];
            }
        }
        return suma;
    }


    }





