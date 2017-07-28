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

import examenes.quimica.modelo.Pregunta;
import examenes.quimica.modelo.TipoRespuesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreguntasDAO extends BaseDAO {

    public PreguntasDAO() {
        super();
    }

    public List<Pregunta> buscarPreguntaMateria(int idMateria) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select p.id, p.pregunta, p.materia, p.respuestas, tp.id idPregunta, tp.descripcion ")
                    .append("from preguntas p inner join tipo_pregunta tp on p.tipo_pregunta = tp.id ")
                    .append("where p.materia = ")
                    .append(idMateria);
            ResultSet rs = getConnection().
                    prepareStatement(sb.toString()).executeQuery();
            
            List<Pregunta> res = new ArrayList<>();
            while(rs.next()) {
                Pregunta p = new Pregunta();
                p.setId(rs.getInt("id"));
                p.setMateria(rs.getInt("materia"));
                p.setRespuestas(rs.getString("respuestas"));
                p.setTipoRespuesta(new TipoRespuesta(rs.getInt("idPregunta"), rs.getString("descripcion")));
                res.add(p);
            }
            return res;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void guardarPregunta(Pregunta pregunta) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("inser into preguntas(pregunta, tipo_respuesta, respuestas, materia) values ('")
                    .append(pregunta.getPregunta().trim()).append("', ")
                    .append(pregunta.getTipoRespuesta().getId()).append(", '")
                    .append(pregunta.getRespuestas().trim()).append(", ")
                    .append(pregunta.getMateria()).append(")");
            
            getConnection().prepareStatement(sb.toString()).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void actualizarPregunta(Pregunta pregunta) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("update preguntas set pregunta = '")
                    .append(pregunta.getPregunta().trim()).append("', tipo_respuesta = ")
                    .append(pregunta.getTipoRespuesta().getId()).append(", respuestas = '")
                    .append(pregunta.getRespuestas().trim()).append(", materia = ")
                    .append(pregunta.getMateria()).append(" where id = ")
                    .append(pregunta.getId());
            
            getConnection().prepareStatement(sb.toString()).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
