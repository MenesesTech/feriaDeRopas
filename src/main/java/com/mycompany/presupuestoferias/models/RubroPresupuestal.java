
package com.mycompany.presupuestoferias.models;

public class RubroPresupuestal {
    private String nombre;
    private String descripcion;
    private String tipoPresupuesto;
    private double monto;

    public RubroPresupuestal() {
    }

    public RubroPresupuestal(String nombre, String descripcion, String tipoPresupuesto, double monto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoPresupuesto = tipoPresupuesto;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoPresupuesto() {
        return tipoPresupuesto;
    }

    public void setTipoPresupuesto(String tipoPresupuesto) {
        this.tipoPresupuesto = tipoPresupuesto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
