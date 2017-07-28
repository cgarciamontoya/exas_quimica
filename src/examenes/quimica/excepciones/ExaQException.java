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
package examenes.quimica.excepciones;

public class ExaQException extends Throwable {
    private static final long serialVersionUID = 8446286884572760252L;

    public ExaQException(String mensaje) {
        super(mensaje);
    }

}
