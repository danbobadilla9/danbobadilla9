/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JabaBeans;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class Item {
    
    private Producto p;
    private int cantidad;

    public Item() {
    }

    public Item(Producto p, int cantidad) {
        this.p = p;
        this.cantidad = cantidad;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
