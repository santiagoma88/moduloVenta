/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *Clase abstracte de los productos, los cuales pueden ser bienes o servicios
 * @author Administrador
 */
public abstract class AbstractProducto {

    private String nombre;
    private boolean esServicio;
    private String fechaEstimada;
    private double precioBrutoUnidad;
    //private double recargo;

    protected AbstractProducto(String nombre, boolean esServicio, String fechaEstimada, double precioBrutoUnidad) {
        this.nombre = nombre;
        this.esServicio = esServicio;
        this.fechaEstimada = fechaEstimada;
        this.precioBrutoUnidad = precioBrutoUnidad;
    }

    /**
     *
     * @return nombre de el producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return true si es servicio, false si es bien(producto fisico)
     */
    public boolean esServicio() {
        return esServicio;
    }

    /**
     *
     * @return fecha de entrega estimada o de prestacion de servicios
     */
    public String getFechaEstimada() {
        return fechaEstimada;
    }

    /**
     *
     * @return precio por unidad del producto
     */
    public double getPrecioBrutoUnidad() {
        return precioBrutoUnidad;
    }

//    /**
//     * Evalua igualdad a un abstractProducto Dos abstractProducto son
//     * cosiderados iguales si son del mismo tipo(bien o servicio) y tienen el
//     * mismo nombre
//     *  (arreglar metodo)clase padre depende de hijo
//     * @param other
//     * @param o objecto a comparar
//     * @return
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//        if (!(o instanceof AbstractProducto)) {
//            return false;
//        }
//        if (o instanceof Servicio) {
//            Servicio servicio=(Servicio) o;            
//            return servicio.equals(this);
//        } else if (o instanceof Bien) { 
//            Bien bien=(Bien) o;            
//            return bien.equals(this);
//        }
//        AbstractProducto abstractProducto = (AbstractProducto) o;
//        return (abstractProducto.nombre.equals(this.nombre) && abstractProducto.esServicio == this.esServicio);
//    }
    
    @Override
    public abstract boolean equals(Object other);
}
