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
package examenes.quimica.modelo;

public class TipoRespuesta {

    private int id;
    private String descripcion;

    public TipoRespuesta() {
    }

    public TipoRespuesta(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
