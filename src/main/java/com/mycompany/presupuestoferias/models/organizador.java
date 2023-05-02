
package com.mycompany.presupuestoferias.models;

public class organizador {
    private int id;
    private String full_name;
    private String email;
    private String telephone;
    private int idFeria;

    public organizador() {
    }

    public organizador(int id, String full_name, String email, String telephone, int idFeria) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.telephone = telephone;
        this.idFeria = idFeria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getIdFeria() {
        return idFeria;
    }

    public void setIdFeria(int idFeria) {
        this.idFeria = idFeria;
    }
    
}
