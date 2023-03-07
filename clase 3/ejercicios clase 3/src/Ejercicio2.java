public class Ejercicio2 {
    public static void main(String[] args) {
        final String abc = "abcdefghijklmnñopqrstuvwxyz ";
        String frase = "hola que tal";
        int desplazamiento = 1; //resultado: ipmbarvfaubm, con desplazamiento de 2: jqncbswgbvcn

        for (int i = 0; i < frase.length(); i++) {
            /*Itero sobre frase, para poder meter el carácter en una variable (caracter) usando charAt(i)*/
            char caracter = frase.charAt(i);
            /*  ¿En qué posición de abc se encuentra el carácter? Uso indexOf */
            int posicion = abc.indexOf(caracter);
            if (posicion == -1) {
                System.out.print(caracter);
            } else {
                /*Varible int que contendrá el nuevo valor de la posición después de sumar el desplazamiento de 1 */
                int nuevaPosicion = posicion + desplazamiento;
                /**
                 * Otras soluciones en reemplazo de los siguientes condicionales:
                 * Tengo que aplicar % (módulo) para que no exceda de los límites de abc y me imprima la "a" en los espacios de esta forma:
                 *          int nuevaPosicion = (posicion + desplazamiento % abc.length());
                 *
                 * Otras soluciones serían dar un espacio en blanco más en abc, o quitar el espacio en blanco en abc, pero esto no "encriptaría" los espacios en blanco.
                 **/
                /*Aca compruebo si la nuevaPosicion es 28 (espacio en blanco) es igual o mayor al largo del abc (incluyendo el espacio en blanco, 28 también)  */
                if (nuevaPosicion >= abc.length()) {
                    /*De ser asi, le resto 28 a nuevaPosicion es decir (28 - 28 = 0), por eso ahora imprimirá "a" para los espacios en blanco*/
                    nuevaPosicion -= abc.length();
                    /*Y Si es menor a 0 que le sume 28*/
                } else if (nuevaPosicion < 0) {
                    nuevaPosicion += abc.length();
                }
                /*Imprimo el char de abc que está en esa nuevaPosicion*/
                System.out.print(abc.charAt(nuevaPosicion));
            }

        }
    }
}

/**
 * Consigna:
 * Genere una clase que tenga los métodos para realizar la codificación y decodificación
 * de un string, dado un número de desplazamiento.
 * <p>
 * Por ejemplo, con desplazo de 1:
 * “hola que tal” -> “ipmbarvfaubm”
 * h -> i
 * o -> p
 * <p>
 * con desplazo de 2
 * “hola que tal” -> “jqncbswgbvcn”
 * h -> j
 * o -> q
 * En el ejemplo estoy usando este abecedario: "
 * abcdefghijklmnñopqrstuvwxyz "
 * Para este ejercicio puede usar todos los métodos de String, tanto de instancia (por
 * ejemplo length) como de clase, por ejemplo String.valueOf(arr) # donde
 * arr es un char[].
 */
