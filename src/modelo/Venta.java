/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Venta {
    private Integer id_venta;
    private String fecha;
    private String usuario;
    private String evento;

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
    private String producto;
    private Integer id_evento;
    private Integer cantidad;
    private String cantRecibida;
    private String cambio;
    private String total;
    private String subTotal;
    

    public Venta(){
        id_venta=null;
        fecha=null;
        usuario=null;
        id_evento=null;
        
    }
    
    public Venta(Integer id_venta, String usuario, String producto, Integer cantidad, String fecha, String subTotal){
        this.id_venta=id_venta;
        this.producto=producto;
        this.fecha=fecha;
        this.usuario=usuario;
        this.cantidad=cantidad;
        this.subTotal=subTotal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCantRecibida() {
        return cantRecibida;
    }

    public void setCantRecibida(String cantRecibida) {
        this.cantRecibida = cantRecibida;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }
    
    
    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }
   
}
