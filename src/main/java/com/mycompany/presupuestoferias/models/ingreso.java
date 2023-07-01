
package com.mycompany.presupuestoferias.models;

public class ingreso {
    private String id;
    private String type;
    private String category;
    private String productoServicio;
    private int cantidad;
    private double precio;
    private double precioTotal;
    private double porcentaje;
    private double totalPrecio;
    private String idFeria;

    public ingreso() {
    }

    public ingreso(String id, String type, String category, String productoServicio, int cantidad, double precio, double precioTotal, double porcentaje, double totalPrecio, String idFeria) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.productoServicio = productoServicio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioTotal = precioTotal;
        this.porcentaje = porcentaje;
        this.totalPrecio = totalPrecio;
        this.idFeria = idFeria;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(double totalPrecio) {
        this.totalPrecio = totalPrecio;
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
