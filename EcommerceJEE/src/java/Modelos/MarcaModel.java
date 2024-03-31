/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import JabaBeans.Marca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class MarcaModel {

    public static ArrayList<Marca> listarTodoDeMarca() {

        try {
            String sql = "{call sp_listartododeMarca()}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia;
            sentencia = c.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<Marca> lista = new ArrayList<>();
            while(resultado.next()){
                Marca marca = new Marca();
                marca.setCodigo(resultado.getInt("codigo"));
                marca.setNombre(resultado.getString("nombre"));
                lista.add(marca);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
