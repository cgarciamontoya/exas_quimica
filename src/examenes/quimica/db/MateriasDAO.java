/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Descripción:
 * Fecha: 27/07/2017
 * Autor: Carlos A. García M.
 */
package examenes.quimica.db;

import examenes.quimica.modelo.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import examenes.quimica.excepciones.ExaQException;

public class MateriasDAO extends BaseDAO {

    public MateriasDAO() {
        super();
    }
    
    public void guardar(String nombre) throws ExaQException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO materias (nombre) values ('")
                    .append(nombre.trim().toUpperCase())
                    .append("')");
            PreparedStatement ps = getConnection().prepareStatement(sb.toString());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new ExaQException("No fue posible guardar la materia, intente mas tarde.");
        }
    }
    
    public void actualizar(Materia materia) throws ExaQException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE materias set nombre = '")
                    .append(materia.getNombre().trim().toUpperCase())
                    .append("' WHERE id = ").append(materia.getId());
            PreparedStatement ps = getConnection().prepareStatement(sb.toString());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new ExaQException("No fue posible actualizar la materia, intente mas tarde.");
        }
    }
    
    public List<Materia> buscar(String nombre) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select id, nombre from materias ");
            if (nombre != null && !nombre.trim().isEmpty()) {
                sb.append("where nombre like '")
                        .append(nombre.trim().toUpperCase()).append("%' ");
            }
            sb.append("order by nombre");
            ResultSet rs = getConnection().
                    prepareStatement(sb.toString()).
                    executeQuery();
            List<Materia> res = new ArrayList<>();
            while (rs.next()) {
                res.add(new Materia(rs.getInt("id"), rs.getString("nombre")));
            }
            return res;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<String> getAllMaterias() {
        try {
            ResultSet rs = getConnection().prepareStatement("select id, nombre, from materias").executeQuery();
            List<String> materias = new ArrayList<>();
            while (rs.next()) {
                materias.add(rs.getInt("id") + " - " + rs.getString("nombre"));
            }
            return materias;
        } catch (SQLException ex) {
            return null;
        }
    }

    
}
