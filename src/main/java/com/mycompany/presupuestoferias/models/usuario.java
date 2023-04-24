
package com.mycompany.presupuestoferias.models;

public class usuario {
    private int id;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String rol;
    private String correo;
    private String telefono;
    private String fecha;

    public usuario() {
    }

    public usuario(int id, String nombre, String usuario, String contarseña, String rol, String correo, String telefono, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contarseña;
        this.rol = rol;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contarseña) {
        this.contraseña = contarseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
