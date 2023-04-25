package interfaces;

import org.example.Empleado;

import java.util.List;

public interface DaoEmpleado {
    public void registrar(Empleado empl) throws Exception;
    public void modificar(Empleado empl) throws Exception;
    public void eliminar(Empleado empl) throws Exception;
    public List<Empleado> listar() throws Exception;
}
