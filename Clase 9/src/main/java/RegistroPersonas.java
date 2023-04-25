import java.util.ArrayList;
import java.util.List;

public class RegistroPersonas {
    private List<Persona> personas = new ArrayList<>();

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void listarPersonas() {
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido() + ", Fecha de nacimiento: " + persona.getFechaNacimiento());
        }
    }
}
