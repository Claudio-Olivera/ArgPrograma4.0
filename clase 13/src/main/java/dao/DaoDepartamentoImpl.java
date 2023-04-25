package dao;

import interfaces.DaoDepartamento;
import org.example.Departamento;
import org.example.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoDepartamentoImpl extends Conexion implements DaoDepartamento {
    @Override
    public void registrar(Departamento dep) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO departamento (nombre_depto,presupuesto) VALUES (?, ?)");

            st.setString(1, dep.getNombre_depto());
            st.setDouble(2, dep.getPresupuesto());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Departamento dep) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE departamento SET presupuesto = ? WHERE nombre_depto = ?");

            st.setString(1, dep.getNombre_depto());
            st.setDouble(2, dep.getPresupuesto());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(Departamento dep) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM departamento WHERE nombre_depto = ?");

            st.setString(1, dep.getNombre_depto());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Departamento> listar() throws Exception {
        List<Departamento> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM departamento");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               Departamento dep= new Departamento();
                dep.setNombre_depto(rs.getString("nombre_depto"));
                dep.setPresupuesto(rs.getDouble("presupuesto"));


                lista.add(dep);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
}

    @Override
    public List<Departamento> alfabeticamente() throws Exception {
        List<Departamento> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM departamento ORDER BY nombre_depto ASC");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Departamento dep= new Departamento();
                dep.setNombre_depto(rs.getString("nombre_depto"));



                lista.add(dep);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    }

