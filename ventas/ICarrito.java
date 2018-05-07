/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *Interfaz que define el comportamiento del carrito de compras
 * @author Administrador
 */
public interface ICarrito {    
    
    /**
     *
     * @param producto AbstractProducto a añadir al carrito 
     * @param cantidad  unidades de dicho producto , si es un servicio sera 1
     */
    public void anadirElemento(AbstractProducto producto, int cantidad);
    
    
    /**
     * Elimina de el carrito el producto 
     * @param producto producto a eliminar
     * @return true si fue eliminado o false si no estaba en el carrito
     */
    public boolean eliminarElemento(AbstractProducto producto);
    
   

    /**
     *  Elimina todos los elementos de el carrito
     */
    public void vaciarCarrito();    
    
}
