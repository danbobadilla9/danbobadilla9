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
public class Categoria implements Serializable{

    private int codigo;
    private String nombre;
    private boolean visible;
    private int categoria_Superior;

    public Categoria() {
    }

    public Categoria(int codigo, int categoria_Superior, String nombre, boolean visible) {
        this.codigo = codigo;
        this.categoria_Superior = categoria_Superior;
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

    public int getCategoria_Superior() {
        return categoria_Superior;
    }

    public void setCategoria_Superior(int categoria_Superior) {
        this.categoria_Superior = categoria_Superior;
    }
    
    
    
}
