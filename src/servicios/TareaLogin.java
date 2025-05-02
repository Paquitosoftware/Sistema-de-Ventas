/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.Login;
/**
 *
 * @author Bambis
 */
public class TareaLogin {
    int rol=0;
    Login datos;
    
    public boolean validarLogin(Connection conexion, String user, String pass) throws SQLException{
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM usuario WHERE usuario='"+user+"' and contrasena='"+pass+"'");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            
            String usuario=resultado.getString("usuario");
            String contrasena=resultado.getString("contrasena");
            
            if(usuario.equals(user)&&contrasena.equals(pass)){
                rol=resultado.getInt("rol");
                return true;
            }
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        } 
        return false;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }


            
            
}
