/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.Usuario;



public class TareaUsuario {
    
    private final String tablaU = "usuario";
    boolean F=true;

    public boolean isF() {
        return F;
    }

    public void setF(boolean F) {
        this.F = F;
    }
    
    
    public List<Usuario> imprimirTodo(Connection conexion) throws SQLException {
        List<Usuario> usuarioX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idUsuario, nombre, apPaterno, apMaterno, usuario, contrasena, rol FROM " + this.tablaU + " ORDER BY idUsuario");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuarioX.add(new Usuario(
                        resultado.getInt("idUsuario"),
                        resultado.getString("nombre"),
                        resultado.getString("apPaterno"),
                        resultado.getString("apMaterno"),
                        resultado.getString("usuario"),
                        resultado.getString("contrasena"),
                        resultado.getInt("rol")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return usuarioX;
    }
    
    
    public void guardar(Connection conexion, Usuario tarea) throws SQLException {
        try{
            PreparedStatement consulta;
                
                consulta = conexion.prepareStatement("INSERT INTO "+this.tablaU+" "
                        + "(idUsuario, nombre, apPaterno, apMaterno, usuario, contrasena, rol)"
                        + " VALUES(0, ?, ?, ?, ?, ?, ?)");
                
                consulta.setString(1, tarea.getNombre());
                consulta.setString(2, tarea.getApellidoP());
                consulta.setString(3, tarea.getApellidoM());
                consulta.setString(4, tarea.getUsuario());
                consulta.setString(5, tarea.getContrasena());
                consulta.setInt(6, tarea.getRol());
                consulta.executeUpdate();
                
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
            
        }
    }
    
    public boolean validaUsuario(Connection conexion, String f) throws SQLException{
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT usuario FROM "+this.tablaU+" WHERE usuario='"+f+"'");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            String n=resultado.getString("usuario");
            System.out.println(n);
            if(n!=f){
                return true;
            }
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        }
        return false;
    }
            
            
    
    public void editar(Connection conexion, Usuario tarea) throws SQLException {
        try{
            F=true;
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE "+this.tablaU+" "
                        + "SET nombre=?,"
                        + " apPaterno=?,"
                        + " apMaterno=?,"
                        + " usuario=?,"
                        + " contrasena=?,"
                        + " rol=?"
                        + " WHERE idUsuario="+tarea.getId_usuario());
                
                consulta.setString(1, tarea.getNombre());
                consulta.setString(2, tarea.getApellidoP());
                consulta.setString(3, tarea.getApellidoM());
                consulta.setString(4, tarea.getUsuario());
                consulta.setString(5, tarea.getContrasena());
                consulta.setInt(6, tarea.getRol());
                consulta.executeUpdate();
            } catch(SQLException ex){
                if(ex.getMessage().equals("Duplicate entry '"+tarea.getUsuario()+"' for key 'usuario'")){
                    System.out.println("Ya existe ese nombre usuario");
                    F=false;
                }
            System.out.println(ex.getMessage()+"  hola hay error");
        }
    }
    
    public void eliminar(Connection conexion, Usuario tarea) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tablaU
                    + " WHERE idUsuario = ?");
            consulta.setInt(1, tarea.getId_usuario());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public List<Usuario> recuperarPorNombre (Connection conexion, String nombre) throws SQLException {
        List<Usuario> usuarioX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idUsuario, nombre, apPaterno, apMaterno, usuario, contrasena, rol FROM " + this.tablaU + " WHERE nombre='"+nombre+"' ORDER BY idUsuario");

            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                usuarioX.add(new Usuario(
                        resultado.getInt("idUsuario"),
                        resultado.getString("Nombre"),
                        resultado.getString("apPaterno"),
                        resultado.getString("apMaterno"),
                        resultado.getString("Usuario"),
                        resultado.getString("Contrasena"),
                        resultado.getInt("rol")
                ));
            }
            F=true;
            if(usuarioX.isEmpty()){
                F=false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return usuarioX;
    }
    
}
