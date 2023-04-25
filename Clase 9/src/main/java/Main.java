import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RegistroPersonas registro = new RegistroPersonas();

        while (true) {
            System.out.println("Ingrese el nombre de la persona, o S para salir");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("s")) {
                break;
            }

            System.out.println("Ingrese el apellido de la persona: ");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese la fecha de nacimiento de la persona (formato yyyy-MM-dd):");
            LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

            Persona persona = new Persona(nombre, apellido, fechaNacimiento);
            registro.agregarPersona(persona);

            System.out.println("Persona agregada: ");
            System.out.println(persona.getNombre() + " " + persona.getApellido() + " " + persona.getFechaNacimiento());
        }

        registro.listarPersonas();}}
