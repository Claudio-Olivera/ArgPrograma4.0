
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Persona {

    String nombre;
    String apellido;
    LocalDate fechadencimiento;

    public LocalDate getFechaNacimiento() {
        return this.fechadencimiento;
    }
}
