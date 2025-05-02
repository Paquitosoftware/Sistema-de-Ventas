/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.*;
import java.util.*;
import modelo.Arqueo;
import modelo.Evento;

public class TareaEvento {
    private final String tablaE = "evento";
    boolean f=true;

    public boolean isF() {
        return f;
    }

    public void setF(boolean f) {
        this.f = f;
    }
    
    
    public List<Evento> recuperarTodas(Connection conexion) throws SQLException {
        List<Evento> eventoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idEvento, nombre, fecha FROM " + this.tablaE + " ORDER BY idEvento");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                eventoX.add(new Evento(resultado.getInt("idEvento"),
                        resultado.getString("nombre"),
                        resultado.getString("fecha")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return eventoX;
    }
    
    public List<Evento> BuscarEvento(Connection conexion, String nombreX)
            throws SQLException {
        List<Evento> eventoX = new ArrayList<>();
        try {

            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tablaE + " WHERE nombre like '"+ nombreX +"%'");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                eventoX.add(new Evento(resultado.getInt("idEvento"), 
                        resultado.getString("nombre"),
                        resultado.getString("fecha")
                ));
            }
            f=true;
            if(eventoX.isEmpty()){
                f=false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return eventoX;
    }
    
    
    public void guardar(Connection conexion, Evento tarea, String monto) throws SQLException {
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("INSERT INTO "+this.tablaE+" "
                        + "(idEvento, nombre, fecha)"
                        + " VALUES(0, ?, ?)");
                
                consulta.setString(1, tarea.getNombre());
                consulta.setString(2, tarea.getFecha());
                consulta.executeUpdate();
                
                consulta = conexion.prepareStatement("UPDATE arqueo SET montoInicial="+monto+" "
                        + "WHERE idEvento=(SELECT max(idEvento) FROM evento)");
                consulta.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        }
    }
    
    public void editar(Connection conexion, Evento tarea) throws SQLException {
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE "+this.tablaE+" "
                        + "SET nombre=?,"
                        + "fecha=? "
                        + "WHERE idEvento="+tarea.getId_evento());
                
                consulta.setString(1, tarea.getNombre());
                consulta.setString(2, tarea.getFecha());
                consulta.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        }
    }
    
    
    public void eliminar(Connection conexion, Evento eventoX) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tablaE
                    + " WHERE idEvento = ?");
            consulta.setInt(1, eventoX.getId_evento());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    
    public List<Evento> eventosPorFecha(Connection conexion) throws SQLException {
        List<Evento> eventoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idEvento, nombre, fecha FROM " + this.tablaE + " ORDER BY fecha DESC");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                eventoX.add(new Evento(resultado.getInt("idEvento"),
                        resultado.getString("nombre"),
                        resultado.getString("fecha")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return eventoX;
    }
    
    public List<Evento> buscarEventoPorFecha(Connection conexion, String fecha) throws SQLException {
        List<Evento> eventoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idEvento, nombre, fecha FROM " + this.tablaE + " WHERE fecha='"+fecha+"' ORDER BY fecha DESC");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                eventoX.add(new Evento(resultado.getInt("idEvento"),
                        resultado.getString("nombre"),
                        resultado.getString("fecha")));
            }
            f=true;
            if(eventoX.isEmpty()){
                f=false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return eventoX;
    }
    
    public List<Arqueo> arqueoCajaRecuperarTodas(Connection conexion) throws SQLException {
        List<Arqueo> arqueoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT montoInicial, montoFinal, fecha, (select nombre from evento "
                    + "WHERE idEvento=arqueo.idEvento) as nombre FROM arqueo ORDER BY fecha DESC");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                arqueoX.add(new Arqueo(resultado.getString("fecha"),
                        resultado.getString("montoInicial"),
                        resultado.getString("montoFinal"),
                        resultado.getString("nombre")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return arqueoX;
    }
    
    public List<Arqueo> arqueoCajaPorFecha(Connection conexion, String fecha) throws SQLException {
        List<Arqueo> arqueoX = new ArrayList<>();
        try {

            PreparedStatement consulta = conexion.prepareStatement("SELECT montoInicial, montoFinal, fecha, (select nombre from evento "
                    + "WHERE idEvento=arqueo.idEvento) as nombre FROM arqueo WHERE fecha='"+fecha+"' ORDER BY fecha DESC");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                arqueoX.add(new Arqueo(resultado.getString("fecha"),
                        resultado.getString("montoInicial"),
                        resultado.getString("montoFinal"),
                        resultado.getString("nombre")
                ));
            }
            f=true;
            if(arqueoX.isEmpty()){
                f=false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return arqueoX;
    }
    
    public void arqueoCajaEditar(Connection conexion, String evento, Double montoInicial) throws SQLException {
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE arqueo"
                        + " SET montoInicial="+montoInicial
                        + " WHERE idEvento=(SELECT idEvento from evento WHERE nombre='"+evento+"')");
                
                consulta.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  Hay un error con MySQL.");
        }
    }
}
