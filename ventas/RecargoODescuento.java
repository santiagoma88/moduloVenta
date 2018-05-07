/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *Impuestos dependiendo del tipo de cliente y su porcentaje asociado
 * @author Administrador
 */
public class RecargoODescuento {
    private boolean aplicaPersona;
    private double porcentaje;

    public RecargoODescuento(boolean aplicaPersona, double porcentaje) {
        this.aplicaPersona = aplicaPersona;
        this.porcentaje = porcentaje;
    }

    public boolean isAplicaPersona() {
        return aplicaPersona;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
    
}
