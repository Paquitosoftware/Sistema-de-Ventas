/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Evento {
    private Integer id_evento;
    private String nombre;
    private String fecha;
    
    public Evento(){
        id_evento=null;
        nombre=null;
        fecha=null;
    }
    
    public Evento(Integer id_evento, String nombre, String fecha){
        this.id_evento=id_evento;
        this.nombre=nombre;
        this.fecha=fecha;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
