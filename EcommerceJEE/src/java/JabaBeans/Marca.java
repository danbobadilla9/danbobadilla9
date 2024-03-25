/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JabaBeans;

import java.io.Serializable;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class Marca implements Serializable{

    private int codigo;
    private String nombre;
    private boolean visible;
    
    
    public Marca() {
    }

    public Marca(int codigo, String nombre, boolean visible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visible = visible;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
}
