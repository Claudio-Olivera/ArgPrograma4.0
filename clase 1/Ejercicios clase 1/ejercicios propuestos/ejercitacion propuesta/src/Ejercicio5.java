import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1, num2, resultado = 0;
        char operacion;

        while (true) {
            System.out.println("Ingrese la operación que desea realizar (+, -, *, /) o presione cualquier tecla para salir:");
            operacion = input.next().charAt(0);

            if (operacion != '+' && operacion != '-' && operacion != '*' && operacion != '/') {
                System.out.println("¡Hasta luego!");
                break;
            }

            System.out.println("Ingrese el primer número:");
            num1 = input.nextDouble();

            System.out.println("Ingrese el segundo número:");
            num2 = input.nextDouble();

            switch (operacion) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: no se puede dividir por cero.");
                        continue;
                    } else {
                        resultado = num1 / num2;
                    }
                    break;
            }

            System.out.println("El resultado es: " + resultado);
        }

        input.close();

    }
}
