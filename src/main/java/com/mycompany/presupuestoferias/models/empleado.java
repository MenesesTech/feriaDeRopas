
package com.mycompany.presupuestoferias.models;

public class empleado {
    //Atributos 
    private String id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String DNI;
    private String district;
    private String email;
    private String telephone;
    private String rol;
    private String created;
    private String updated;
    
    //Constructor vacia de la clase empleado
    public empleado() {
    }

    /**
     * Constructor de la clase empleado
     * 
     * @param id ID del empleado
     * @param username Nombre de usuario del empleado
     * @param password Contraseña del empleado
     * @param name  Nombre del empleado
     * @param lastName Apellido del empleado
     * @param DNI DNI del empleado
     * @param district Distrito del empleado
     * @param email Email del empleado
     * @param telephone Teléfono del empleado
     * @param rol Rol del empleado
     * @param created Fecha de creación del empleado
     * @param updated Fecha de actualización del empleado
     */
    public empleado(String id, String username, String password, String name, String lastName, String DNI, String district, String email, String telephone, String rol, String created, String updated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.district = district;
        this.email = email;
        this.telephone = telephone;
        this.rol = rol;
        this.created = created;
        this.updated = updated;
    }
    //Metodos get-set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
    
}
