/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.util.List;

/**
 *Una venta debe tomar una carrito, un cliente, y un recargo o descuento
 * (solo esta el de impuestos que manda el modulo de personal) y con esto obtener
 * el costo total y las fechas estimadas
 * @author Administrador
 */
public class Venta implements IVenta {

    final double RECARGO_FUERA_AREA_METROPOLITANA = 50000;
    final private int UNIDADES_PARA_DESCUENTO = 12;
    final private int PORCENTAJE_AL_POR_MAYOR = -2;//2% descuento
    final private int PORCENTAJE_PRODUCTOS_Y_SERVICIOS = -5;//5% descuento
    
    

    private Carrito carrito;
    private Cliente cliente;
    private RecargoODescuento recargoODescuento;
    //reglas , recargos y eso
    private double subtotal=0;
    private double baseImponible=0;
    private double total=0;

    /**
     * Genera la venta por medio del metodo realizar venta, el cual 
     * aplica descuentos indicviduales por productos,
     * obtiene el subtotal,
     * obtiene base imponible(subtotal- descuentos o recargos globales),
     * calcula total(aplica impuestos)
     * @param carrito carrito de compra asociado a la venta
     * @param cliente cliente asociado a la venta
     * @param recargoODescuento recargo asociado a la venta
     */
    public Venta(Carrito carrito, Cliente cliente,RecargoODescuento recargoODescuento) {
        this.carrito = carrito;
        this.cliente = cliente;
        this.recargoODescuento=recargoODescuento;
        realizarVenta();
    }
    
    private void realizarVenta(){
        aplicarRYDProductos();
        this.subtotal=calcularSubtotal();
        this.baseImponible=calcularBaseImponible(this.subtotal);
        this.total=calcularTotal(baseImponible, recargoODescuento);
    }    
    
    
    private double calcularTotal(double baseImponible,RecargoODescuento recargoODescuento) {
        double totalCalculado=baseImponible;                
        if(recargoODescuento.isAplicaPersona()==this.cliente.esPersona()){//si es persona y aplica a persona o es empresa y aplica a empresa
            totalCalculado=baseImponible*(1+(recargoODescuento.getPorcentaje()/100));
        }
       return totalCalculado;
    }

 

    /**    
     *
     * @return sumatoria de el costo de todos los productos del carrito teniendo en cuenta sus descuentos o recargos
     */
    private double calcularSubtotal() {
        double subtotalCalculado = 0;        
        for (CuatroTupla nT : carrito.getCarrito()) {
            subtotalCalculado+= nT.getPrecioBase()*(nT.getPorcentaje()/100);// aplicar descuento o recargo y añadir a subtotal            
        }
        return subtotalCalculado;
    }

    /**
     * Se aplican descuentos o recargos al total de la venta
     * ¡¡¡¡HardCoded!!!!!!
     * @param subTotal valor al cual se le aplican
     * @return 
     */
    private double calcularBaseImponible(double subTotal){
        subTotal+=calcularRecargoFueraAreaMetropolitana();
        return subTotal;
    }
    
      @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void getFechas(){       
        
    }

    
    /**
     * Modifica el campo porcentaje de la tupla para que quede indicado el porcentaje qque cambia el precio base del producto
     * ¡¡¡HardCoded!!!
     */
    private void aplicarRYDProductos() {
        //descuento por compra al por mayor
        for (CuatroTupla nT : carrito.getCarrito()) {
            if (nT.getCantidad() >= UNIDADES_PARA_DESCUENTO) {
                nT.setPorcentaje(nT.getPorcentaje() + PORCENTAJE_AL_POR_MAYOR);
            }
        }
        
        
        
        //descuento por servicios y bienes
        boolean bienes = false;
        boolean servicios = false;  
        for (CuatroTupla nT : carrito.getCarrito()) {
            if (nT.getProducto().esServicio()) {
                servicios = true;
            } else {
                bienes = true;
            }
            if (servicios && bienes) {
                for (CuatroTupla nT2 : carrito.getCarrito()) {
                    nT2.setPorcentaje(nT2.getPorcentaje() + PORCENTAJE_PRODUCTOS_Y_SERVICIOS);
                }
                break;
            }
        }

    }    
    
    private double calcularRecargoFueraAreaMetropolitana() {
        double recargoCalculado = 0;
        for (CuatroTupla nt : carrito.getCarrito()) {
            if (nt.getProducto().esServicio()) {
                Servicio servicio = (Servicio) nt.getProducto();
                if (!servicio.esEnAreaMetropolitana()) {
                    recargoCalculado += RECARGO_FUERA_AREA_METROPOLITANA;
                }
            }
        }
        return recargoCalculado;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getBaseImponible() {
        return baseImponible;
    }    

    public RecargoODescuento getRecargoODescuento() {
        return recargoODescuento;
    }

}
