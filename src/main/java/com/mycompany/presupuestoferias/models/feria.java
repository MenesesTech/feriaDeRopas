
package com.mycompany.presupuestoferias.models;

import java.sql.Date;

public class feria {
    //Atributos
    private int id;
    private String name;
    private String address;
    private String category;
    private String status;
    private String organizador;
    private String telephone;
    private String email;
    private String rol;
    private Date dateInicio;
    private Date dateFin;

    public feria() {
    }

    public feria(int id, String name, String address, String category, String status, String organizador, String telephone, String email, String rol, Date dateInicio, Date dateFin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.category = category;
        this.status = status;
        this.organizador = organizador;
        this.telephone = telephone;
        this.email = email;
        this.rol = rol;
        this.dateInicio = dateInicio;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(Date dateInicio) {
        this.dateInicio = dateInicio;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
}