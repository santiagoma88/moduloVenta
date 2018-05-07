/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.util.Objects;

/**
 *4-tupla que contiene un producto , cantidad/unidades de este(si es un servicio sera 1) , 
 * un precioBase(producto*cantidad), y otro campo para el % de descuento o recargo al producto
 * @author Administrador
 */
public class CuatroTupla {
    private AbstractProducto producto;
    private int cantidad;
    private double precioBase;
    private double porcentaje;

    /**
     * Crea una 4-tupla 
     * @param producto producto
     * @param cantidad numero deunidades de un bien(producto fisico) o 1 si es servicio
     */
    public CuatroTupla(AbstractProducto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        if(producto.esServicio()){
            this.cantidad=1;
        }        
        this.precioBase= cantidad *this.producto.getPrecioBrutoUnidad();
        this.porcentaje=100;
            }

    /**
     *
     * @return producto perteneciente a la dupla
     */
    public AbstractProducto getProducto() {
        return producto;
    }

    /**
     *
     * @return unidades del producto. Si es un sevicio retorna 1
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     *
     * @return precioBase correspondiente al precio unitario por el numero de unidades
     */
    public double getPrecioBase() {
        return precioBase;
    }

    
    protected double getPorcentaje() {
        return porcentaje;
    }

    protected void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    
    
    
    
    
    
    
}
