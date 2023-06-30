
package com.mycompany.presupuestoferias.models;

public class egreso {
    private String id;
    private String type;
    private String category;
    private String productoServicio;
    private int cantidad;
    private double precio;
    private String idFeria;

    public egreso() {
    }

    public egreso(String id, String type, String category, String productoServicio, int cantidad, double precio, String idFeria) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.productoServicio = productoServicio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idFeria = idFeria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(String productoServicio) {
        this.productoServicio = productoServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIdFeria() {
        return idFeria;
    }

    public void setIdFeria(String idFeria) {
        this.idFeria = idFeria;
    }

    
}
