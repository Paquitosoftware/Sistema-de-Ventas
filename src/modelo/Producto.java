/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Producto {
    private Integer id_producto;
    private String nombre;
    private String precio;
    private String tipo;
    private Integer id_categoria;
    private String nombre_categoria;
    
    
    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    
    public Producto(){
        id_producto=null;
        nombre=null;
        precio=null;
        tipo=null;
        id_categoria=null;
        nombre_categoria=null;
    }
    
    public Producto(Integer id_producto, String nombre, String precio, String tipo, Integer id_categoria, String nombre_categoria){
        this.id_producto=id_producto;
        this.nombre=nombre;
        this.precio=precio;
        this.tipo=tipo;
        this.id_categoria=id_categoria;
        this.nombre_categoria=nombre_categoria;
    }
    
    
    public Integer getId_producto() {
        return id_producto;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;}
    
}
