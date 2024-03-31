/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class ProductoModel {
    public static boolean registrarProducto(int codigoSuperior){
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
}
