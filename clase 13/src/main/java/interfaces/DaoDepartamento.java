package interfaces;

import org.example.Departamento;

import java.util.List;

public interface DaoDepartamento {

    public void registrar(Departamento dep) throws Exception;
    public void modificar(Departamento dep) throws Exception;
    public void eliminar(Departamento dep) throws Exception;
    public List<Departamento> listar() throws Exception;
    public List<Departamento> alfabeticamente() throws Exception;
}
