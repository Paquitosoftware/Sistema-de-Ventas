
package servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Producto;

/**

*
 * @author DesktopG
 */
public class TareaProducto {
    
    private final String tablaP = "producto";
    private final String tablaC = "categoria";
    boolean f=true;

    public boolean isF() {
        return f;
    }

    public void setF(boolean f) {
        this.f = f;
    }
    
    public List<Producto> recuperarTodas(Connection conexion) throws SQLException {
        List<Producto> productoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idProducto, Producto.nombre, precio, tipo, Producto.idCategoria, Categoria.Nombre FROM " + this.tablaP + ", " + this.tablaC + " where Producto.idCategoria=Categoria.idCategoria ORDER BY idProducto");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                productoX.add(new Producto(
                        resultado.getInt("idProducto"),
                        resultado.getString("Producto.nombre"),
                        resultado.getString("Precio"),
                        resultado.getString("Tipo"),
                        resultado.getInt("idCategoria"),
                        resultado.getString("Categoria.nombre")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return productoX;
    }
    
    public void guardar(Connection conexion, Producto tarea) throws SQLException {
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("INSERT INTO "+this.tablaP+" "
                        + "(idProducto, nombre, precio, tipo, idCategoria)"
                        + " VALUES(0, ?, ?, ?, (SELECT idCategoria FROM categoria WHERE nombre=?))");
                
                consulta.setString(1, tarea.getNombre());
                consulta.setString(2, tarea.getPrecio());
                consulta.setString(3, tarea.getTipo());
                consulta.setString(4, tarea.getNombre_categoria());         
                consulta.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        }
    }
    
    public void editar(Connection conexion, Producto tarea) throws SQLException {
        try{
            PreparedStatement consulta;
                consulta = conexion.prepareStatement("UPDATE "+this.tablaP+" "
                        + "SET nombre=?,"
                        + " tipo=?,"
                        + " precio=?,"
                        + " idCategoria=(SELECT idCategoria FROM categoria WHERE nombre=?) "
                        + "WHERE idProducto="+tarea.getId_producto());
                
                consulta.setString(1, tarea.getNombre());
                consulta.setString(2, tarea.getTipo());
                consulta.setDouble(3, Double.parseDouble(tarea.getPrecio()));
                consulta.setString(4, tarea.getNombre_categoria());
                consulta.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage()+"  hola hay error");
        }
    }
    
    
    public void eliminar(Connection conexion, Producto tarea) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tablaP
                    + " WHERE idProducto = ?");
            consulta.setInt(1, tarea.getId_producto());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public List<Producto> recuperarPorNombre (Connection conexion, String nombre) throws SQLException {
        List<Producto> productoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idProducto, Producto.nombre, precio, tipo, Producto.idCategoria, Categoria.Nombre FROM " + this.tablaP + ", " + this.tablaC + " where Producto.idCategoria=Categoria.idCategoria and Producto.nombre like "+"'"+nombre+"%'"+" ORDER BY idProducto");

            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                productoX.add(new Producto(
                        resultado.getInt("idProducto"),
                        resultado.getString("Producto.nombre"),
                        resultado.getString("Precio"),
                        resultado.getString("Tipo"),
                        resultado.getInt("idCategoria"),
                        resultado.getString("Categoria.nombre")
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
    
    public List<Producto> recuperarPorTipo(Connection conexion, String tipo) throws SQLException {
        List<Producto> productoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idProducto, Producto.nombre, precio, tipo, Producto.idCategoria, Categoria.Nombre FROM producto inner join categoria on (Producto.idCategoria=Categoria.idCategoria) WHERE tipo like "+"'"+tipo+"%'"+" ORDER BY idProducto");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                productoX.add(new Producto(
                        resultado.getInt("idProducto"),
                        resultado.getString("Producto.nombre"),
                        resultado.getString("Precio"),
                        resultado.getString("Tipo"),
                        resultado.getInt("idCategoria"),
                        resultado.getString("Categoria.nombre")
                ));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return productoX;
    }
    
    public int validarProductoNombre(Connection conexion, String nombre, String precio) throws SQLException {
        int idProducto=0;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idProducto FROM producto WHERE nombre="+"'"+nombre+"'  and precio='"+precio+"'");

            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            idProducto=resultado.getInt("idProducto");
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return idProducto;
    }
    
    
    public List<Producto> recuperarPorId (Connection conexion, Integer idProducto) throws SQLException {
        List<Producto> productoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idProducto, Producto.nombre, precio, tipo, Producto.idCategoria, Categoria.Nombre FROM " + this.tablaP + ", " + this.tablaC + " "
                    + "                                            WHERE Producto.idCategoria=Categoria.idCategoria and Producto.idProducto="+"'"+idProducto+"'");

            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                productoX.add(new Producto(
                        resultado.getInt("idProducto"),
                        resultado.getString("Producto.nombre"),
                        resultado.getString("Precio"),
                        resultado.getString("Tipo"),
                        resultado.getInt("idCategoria"),
                        resultado.getString("Categoria.nombre")
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
    
    
    public List<Producto> recuperarPorCategoria(Connection conexion, String cat) throws SQLException {
        List<Producto> productoX = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idProducto, Producto.nombre, precio, tipo, Producto.idCategoria, Categoria.Nombre FROM producto inner join categoria on (Producto.idCategoria=Categoria.idCategoria) WHERE "
                    + "                                             categoria.nombre="+"'"+cat+"' "+" ORDER BY idProducto");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                productoX.add(new Producto(
                        resultado.getInt("idProducto"),
                        resultado.getString("Producto.nombre"),
                        resultado.getString("Precio"),
                        resultado.getString("Tipo"),
                        resultado.getInt("idCategoria"),
                        resultado.getString("Categoria.nombre")
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
    

        