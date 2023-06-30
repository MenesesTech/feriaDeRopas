package com.mycompany.presupuestoferias.models;

import java.sql.Date;

public class feria {
    //Atributos
    private String id;
    private String name;
    private String district;
    private int aforo;
    private double monto;
    private String status;
    private String category;
    private Date dateInicio;
    private Date dateFin;

    //Constructor vacio de la clase Feria
    public feria() {
    }

    /**
     * Constructor de la clase feria.
     *
     * @param id ID de la feria.
     * @param name Nombre de la feria.
     * @param district Distrito de la feria.
     * @param aforo Aforo de la feria.
     * @param monto Monto de la feria.
     * @param status Estado de la feria.
     * @param category Categoría de la feria.
     * @param dateInicio Fecha de inicio de la feria.
     * @param dateFin Fecha de fin de la feria.
     */
    public feria(String id, String name, String district, int aforo, double monto, String status, String category, Date dateInicio, Date dateFin) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.aforo = aforo;
        this.monto = monto;
        this.status = status;
        this.category = category;
        this.dateInicio = dateInicio;
        this.dateFin = dateFin;
    }
    
    //Metodos get-set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
