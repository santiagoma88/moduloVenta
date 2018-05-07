/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *Cliente que cuenta con id,nombre,contacto, esPersona(tipo de cliente)
 * @author Administrador
 */
public class Cliente {
    private String id;
    private String nombre;
    private String contacto;
    private boolean esPersona;

    /**
     * crea cliente , que puede ser empresa o persona
     * @param esPersona indica si es empresa o persona
     * @param id  cc o nit
     * @param nombre nombre o razon social
     * @param contacto numero o correo
     * 
     */
    public Cliente(boolean esPersona, String id, String nombre, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.esPersona = esPersona;
    }

    /**
     *
     * @return cc o nit
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return nombre o razon social
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return numero o correo
     */
    public String getContacto() {
        return contacto;
    }

    /**
     *
     * @return true si es persona o false si es empresa(institucion)
     */
    public boolean esPersona() {
        return esPersona;
    }
       

    
}
