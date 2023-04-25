package dao;

import interfaces.DaoEmpleado;
import org.example.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpleadoImpl extends Conexion implements DaoEmpleado {

    @Override
    public void registrar(Empleado empl) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Empleado (DNI, nombre, apellido, nacionalidad, departamento) VALUES (?, ?, ?, ?, ?)");

            st.setString(1, empl.getDNI());
            st.setString(2, empl.getNombre());
            st.setString(3, empl.getApellido());
            st.setString(4, empl.getNacionalidad());
            st.setString(5, empl.getDepartamento());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Empleado empl) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Empleado set  nacionalidad = ? WHERE DNI = ?");
            st.setString(1, empl.getNacionalidad());
            st.setString(2, empl.getDNI());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Empleado empl) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Empleado WHERE DNI = ?");

            st.setString(1, empl.getDNI());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Empleado> listar() throws Exception {
        List<Empleado> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Empleado");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Empleado empl = new Empleado();
                empl.setDNI(rs.getString("DNI"));
                empl.setNombre(rs.getString("nombre"));
                empl.setApellido(rs.getString("apellido"));
                empl.setNacionalidad(rs.getString("nacionalidad"));
                empl.setDepartamento(rs.getString("departamento"));

                lista.add(empl);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
