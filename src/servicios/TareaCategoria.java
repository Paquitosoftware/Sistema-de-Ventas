/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;


public class TareaCategoria {
    private final String tablaC = "categoria";
    boolean f=true;

    public boolean isF() {
        return f;
    }

    public void setF(boolean f) {
        this.f = f;
    }
    
    
    public List<Categoria> recuperarTodas(Connection conexion) throws SQLException {
        List<Categoria> categoriaX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idCategoria, nombre FROM " + this.tablaC + " ORDER BY idCategoria");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                categoriaX.add(new Categoria(
                        resultado.getInt("idCategoria"),
                        resultado.getString("nombre")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return categoriaX;
    }
    
    
    public void guardar(Connection conexion, Categoria tarea) throws SQLException {
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("INSERT INTO "+this.tablaC+" "
                        + "(idCategoria, nombre)"
                        + " VALUES(0, ?)");
                
                consulta.setString(1, tarea.getNombre());
                consulta.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        }
    }
    
    public void editar(Connection conexion, Categoria tarea) throws SQLException {
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE "+this.tablaC+" "
                        + "SET nombre=?"
                        + "WHERE idCategoria="+tarea.getId_categoria());
                
                consulta.setString(1, tarea.getNombre());
                consulta.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        }
    }
    
    public void eliminar(Connection conexion, Categoria categoriaX) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tablaC
                    + " WHERE idCategoria = ?");
            consulta.setInt(1, categoriaX.getId_categoria());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    
    public List<Categoria> recuperarPorNombre (Connection conexion, String nombre) throws SQLException {
        List<Categoria> productoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idCategoria, nombre FROM categoria WHERE nombre like '"+nombre+"%'");
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                productoX.add(new Categoria(
                        resultado.getInt("idCategoria"),
                        resultado.getString("nombre")
                ));
            }
            f=true;
            if(productoX.isEmpty()){
                f=false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return productoX;
    }
}