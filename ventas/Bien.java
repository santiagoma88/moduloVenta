/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.util.Objects;

/**
 *Bien (producto fisico)que se vende
 * @author Administrador
 */
public class Bien extends AbstractProducto{    
  
    /**
     * Crea un nuevo bien(producto fisico)
     *
     * @param nombre nombre del producto
     * @param fechaEstimada fecha estimada de entrega
     * @param precioBrutoUnidad precio por unidad
     * 
     * 
     * 
     */
    public Bien(String nombre, String fechaEstimada, double precioBrutoUnidad) {
        super(nombre,false , fechaEstimada, precioBrutoUnidad);
       
        
    }   
///**
// * True si tienen mismo nombre
// * @param obj
// * @return 
// */
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Bien other = (Bien) obj;
//        if (!Objects.equals(this.getNombre(), other.getNombre())
//                && !(this.esServicio() == other.esServicio())
//                ) {
//            return false;
//        }
//        return true;
//    }
//    

        /**
         * Un bien es igual a otro si tienen el mismo nombre
         * @param obj
         * @return 
         */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bien other = (Bien) obj;
        if (!this.getNombre().equals(other.getNombre())) {
            return false;
        }        
        return true;
    }
    
    
}
