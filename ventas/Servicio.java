/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.util.Objects;

/**
 *Servicio que se vende
 * @author Administrador
 */
public class Servicio extends AbstractProducto {

    private String facilitador;
    private String direccion;
    private boolean enAreaMetropolitana;

    /**
     * Crea un nuevo servicio
     *
     * @param nombre nombre del servicio
     * @param fechaEstimada fecha programada para prestacion del servicio
     * @param precioBrutoUnidad costo del servicio
     * @param facilitador nombre de la persona encargada de prestar el
     * servicio(taller o capacitacion)
     * @param direccion direccion en donde se debera prestar el servicio
     * @param enAreaMetropolitana define si el servicio sera prestado dentro del
     * area metropolitana
     */
    public Servicio(String nombre, String fechaEstimada, double precioBrutoUnidad, String facilitador, String direccion, boolean enAreaMetropolitana) {
        super(nombre, true, fechaEstimada, precioBrutoUnidad);
        this.facilitador = facilitador;
        this.direccion = direccion;
        this.enAreaMetropolitana = enAreaMetropolitana;
    }

    /**
     *
     * @return nombre de la persona encargada de prestar el servicio(taller o
     * capacitacion)
     */
    public String getFacilitador() {
        return facilitador;
    }

    /**
     *
     * @return direccion en donde se debera prestar el servicio
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @return si el servicio sera prestado dentro del area metropolitana
     */
    public boolean esEnAreaMetropolitana() {
        return enAreaMetropolitana;
    }

//    /**
//     * Dos servicios son iguales si tienen el mismo nombre,feha y facilitador
//     *
//     * @param obj
//     * @return
//     */
//    @Override
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
//        final Servicio other = (Servicio) obj;
//        if (!Objects.equals(this.facilitador, other.facilitador)
//                && !Objects.equals(this.getFechaEstimada(), other.getFechaEstimada())
//                && !(this.esServicio() == other.esServicio())
//                && !Objects.equals(this.getNombre(), other.getNombre())) {
//            return false;
//        }
//        return true;
//    }
    /**
     *Un servicio es igual a otro si tienen el mismo nombre, facilitador y fecha
     *
     * @return true si son iguales false de lo contrario
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
        final Servicio other = (Servicio) obj;

        if (!Objects.equals(this.getNombre(), other.getNombre())) {
            return false;
        }

        if (!Objects.equals(this.facilitador, other.facilitador)) {
            return false;
        }
        if (!Objects.equals(this.getFechaEstimada(), other.getFechaEstimada())) {
            return false;
        }
        return true;
    }

}
