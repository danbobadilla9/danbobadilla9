/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import JabaBeans.Categoria;
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
public class CategoriaModel {
    public static ArrayList<Categoria> listar(){
        String sql = "{CALL sp_listarCategoriaSuperior()}";
        Connection c = Conexion.conectar();
        CallableStatement sentencia;
        ResultSet resultado;
        try {
            sentencia = c.prepareCall(sql);
            resultado = sentencia.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            
            while(resultado.next()){
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static ArrayList<Categoria> listarSubCategoria(int codigoSuperior){
        try{
            String sql = "{ CALL sp_listarSubCategoria(?) }";
            Connection c = Conexion.conectar();
            CallableStatement sentencia = c.prepareCall(sql);
            sentencia.setInt(1, codigoSuperior);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            while(resultado.next()){
                Categoria categoria = new Categoria();
                categoria.setCodigo(resultado.getInt("codigo"));
                categoria.setNombre(resultado.getString("nombre"));
                lista.add(categoria);
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }
    
    public static ArrayList<Categoria> listarTodoDeCategorias(){
        try{
            String sql = "{ CALL sp_listarTodo() }";
            Connection c = Conexion.conectar();
            CallableStatement sentencia = c.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            while(resultado.next()){
                Categoria categoria = new Categoria();
                categoria.setCodigo(resultado.getInt("codigo"));
                categoria.setNombre(resultado.getString("nombre"));
                lista.add(categoria);
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }
    
    public static boolean esSuperior(int codigoSuperior){
        try{
            String sql = "{ CALL contarSubcategorias(?) }";
            Connection c = Conexion.conectar();
            CallableStatement sentencia = c.prepareCall(sql);
            sentencia.setInt(1, codigoSuperior);
            ResultSet resultado = sentencia.executeQuery();
            resultado.next();
            return resultado.getInt("cantidad") > 0;
        }catch(SQLException ex){
            return false;
        }
    }
}
