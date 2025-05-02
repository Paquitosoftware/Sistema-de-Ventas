package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Usuario {
    private Integer id_usuario;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String usuario;
    private String contrasena;
    private Integer rol;
    private String tipoRol;
    
    public Usuario(){
        id_usuario=null;
        nombre=null;
        apellidoM=null;
        apellidoP=null;
        usuario=null;
        contrasena=null;
        rol=null;
        tipoRol=null;
    }
    
    public Usuario(Integer id_usuario, String nombre, String apellidoP, String apellidoM, String usuario, String contrasena, Integer rol){
        this.id_usuario=id_usuario;
        this.nombre=nombre;
        this.apellidoM=apellidoM;
        this.apellidoP=apellidoP;
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.rol=rol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }
    
}
