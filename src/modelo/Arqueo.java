/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Arqueo {
    String id_arqueo=null;
    String montoInicial=null;
    String montoFinal=null;
    String fecha=null;
    String evento=null;

    public Arqueo(String fecha, String montoInicial, String montoFinal, String evento){
        this.fecha = fecha;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.evento = evento;
    }

    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId_arqueo() {
        return id_arqueo;
    }

    public void setId_arqueo(String id_arqueo) {
        this.id_arqueo = id_arqueo;
    }

    public String getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(String montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(String montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
    
    
    

}
