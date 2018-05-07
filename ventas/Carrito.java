/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.util.ArrayList;
import java.util.List;

/**
 *Carrito de compras, implementado con una Lista de "CuatroTupla" en las que se guardan
 * producto,cantidad/unidades, precio base, porcentaje de modificion(descuentos,recargos)
 * @author Administrador
 */
public class Carrito implements ICarrito {

    private List<CuatroTupla> carrito;   //String organizado 
    //nombre+tipo+fechaEstimada+precioBrutoPorUnidad+

    /**
     * Crea un carrito vacio
     */
    public Carrito() {
        this.carrito = new ArrayList<>();
    }

    @Override
    public void anadirElemento(AbstractProducto producto, int cantidad) {
        CuatroTupla nt = new CuatroTupla(producto, cantidad);
        carrito.add(nt);
    }

    /**
     *Indice de el elemento dentro del carrito
     * @return  -1 si no esta o el indice
     */
    private int indiceElementoCarrito(AbstractProducto abstractProducto) {
        int i = 0;
        for (CuatroTupla nt : carrito) {
            if (nt.getProducto().equals(abstractProducto)) {
                return i;
            }
            i++;
        }
        
        return -1;
    }

    @Override
    public boolean eliminarElemento(AbstractProducto producto) {
        int indice = indiceElementoCarrito(producto);
        if (indice == -1) {
            return false;
        } else {
            carrito.remove(indice);
            return true;
        }
    }

    @Override
    public void vaciarCarrito() {
        this.carrito.clear();
    }

    /**
     *
     * @return List de cuatroTupla en la que se encuentra cada producto de el carrito , asi como su cantidad 
     */
    public List<CuatroTupla> getCarrito() {
        return carrito;
    }

}
