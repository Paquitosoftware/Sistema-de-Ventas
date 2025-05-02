/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Venta;

public class TareaVenta {
    private boolean insGreat=false;

    public boolean isInsGreat() {
        return insGreat;
    }

    public void setInsGreat(boolean insGreat) {
        this.insGreat = insGreat;
    }
    
    public List<Venta> imprimirVentas(Connection conexion) throws SQLException {
        List<Venta> ventaX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idVenta, (select nombre from usuario where idUsuario=(select idVendedor from venta where idVenta=productoventa.idVenta)) as vendedor, (select nombre from producto where idProducto=productoventa.idProducto) as producto, cantidad, subTotal, (select fecha FROM venta WHERE idVenta=productoventa.idVenta) as fecha FROM productoventa");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ventaX.add(new Venta(
                        resultado.getInt("idVenta"),
                        resultado.getString("vendedor"),
                        resultado.getString("producto"),
                        resultado.getInt("cantidad"),
                        resultado.getString("fecha"),
                        resultado.getString("subTotal")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return ventaX;
    }
    
    
    public List<Venta> imprimirVentasEvento(Connection conexion, String evento) throws SQLException {
        List<Venta> ventaX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT productoventa.idVenta, "
                                                                + "(select nombre from usuario where idUsuario=(select idVendedor from venta where idVenta=productoventa.idVenta)) as vendedor, "
                                                                + "(select nombre from producto where idProducto=productoventa.idProducto) as producto, cantidad, subTotal, "
                                                                + "(select fecha from venta where idVenta=productoventa.idVenta) as fecha from productoventa inner join venta on "
                                                                + "(productoventa.idVenta=venta.idVenta) where idEvento=(select idEvento from evento where nombre='"+evento+"')");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ventaX.add(new Venta(
                        resultado.getInt("idVenta"),
                        resultado.getString("vendedor"),
                        resultado.getString("producto"),
                        resultado.getInt("cantidad"),
                        resultado.getString("fecha"),
                        resultado.getString("subTotal")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return ventaX;
    }
    
    
    public List<Venta> imprimirVentasFecha(Connection conexion, String fecha) throws SQLException {
        List<Venta> ventaX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT productoventa.idVenta, "
                                                                + "(select nombre from usuario where idUsuario=(select idVendedor from venta where idVenta=productoventa.idVenta)) as vendedor, "
                                                                + "(select nombre from producto where idProducto=productoventa.idProducto) as producto, cantidad, subTotal, "
                                                                + "(select fecha from venta where idVenta=productoventa.idVenta) as fecha from productoventa inner join venta on "
                                                                + "(productoventa.idVenta=venta.idVenta) where fecha='"+fecha+"'");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ventaX.add(new Venta(
                        resultado.getInt("idVenta"),
                        resultado.getString("vendedor"),
                        resultado.getString("producto"),
                        resultado.getInt("cantidad"),
                        resultado.getString("fecha"),
                        resultado.getString("subTotal")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return ventaX;
    }
    
    
    
    public List<Venta> imprimirVentasAnio(Connection conexion, Integer anio) throws SQLException {
        List<Venta> ventaX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT productoventa.idVenta, "
                                                                + "(select nombre from usuario where idUsuario=(select idVendedor from venta where idVenta=productoventa.idVenta)) as vendedor, "
                                                                + "(select nombre from producto where idProducto=productoventa.idProducto) as producto, cantidad, subTotal, "
                                                                + "(select fecha from venta where idVenta=productoventa.idVenta) as fecha from productoventa inner join venta on "
                                                                + "(productoventa.idVenta=venta.idVenta) where year(fecha)='"+anio+"'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ventaX.add(new Venta(
                        resultado.getInt("idVenta"),
                        resultado.getString("vendedor"),
                        resultado.getString("producto"),
                        resultado.getInt("cantidad"),
                        resultado.getString("fecha"),
                        resultado.getString("subTotal")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return ventaX;
    }
    
    
    public void guardarVenta(Connection conexion, Venta tarea) throws SQLException {
        try{
            
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("INSERT INTO venta"
                        + "(idVenta, fecha, idVendedor, idEvento, cantRecibida, cambio, total)"
                        + " VALUES(0,"
                        + " ?, "
                        + "(SELECT idUsuario from usuario WHERE usuario=?), "
                        + "(SELECT idEvento from evento WHERE nombre=?), "
                        + " ?,"
                        + " ?,"
                        + " ?)");
                
                consulta.setString(1, tarea.getFecha());
                consulta.setString(2, tarea.getUsuario());
                consulta.setString(3, tarea.getEvento());
                consulta.setString(4, tarea.getCantRecibida());
                consulta.setString(5, tarea.getCambio());
                consulta.setString(6, tarea.getTotal());
                
                
                consulta.executeUpdate();
                insGreat=true;
            } catch(SQLException ex){
                System.out.println(ex.getMessage()+"  Hay un error con SQL.");
                insGreat=false;
        }
    }
    
    public void guardarProductoVenta(Connection conexion, String nombre, Integer cant, String subT)throws SQLException{
        try{
        PreparedStatement consulta;
        consulta = conexion.prepareStatement("INSERT INTO productoventa"
                + "(idProducto, idVenta, cantidad, subTotal)"
                + "VALUES((SELECT idProducto from producto WHERE nombre='"+nombre+"'), "
                + "(SELECT max(idVenta) from venta), "
                +cant+", "
                +"'"+subT+"')");
        consulta.execute();
        } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  Hay un error con SQL.");
        }
    }
    
    public void guardarProductoVenta2(Connection conexion, Venta tarea)throws SQLException{
        try{
        
        PreparedStatement consulta;
        consulta = conexion.prepareStatement("INSERT INTO productoventa"
                + "(idProducto, idVenta, cantidad, subTotal)"
                + "VALUES((SELECT idProducto from producto WHERE nombre=?), "
                + "(SELECT max(idVenta) from venta), "
                +"?, "
                +"?)");
        consulta.setString(1, tarea.getProducto());
        consulta.setInt(2, tarea.getCantidad());
        consulta.setString(3, tarea.getSubTotal());
        consulta.executeUpdate();
        } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  Hay un error con SQL.");
        }
    }
}
