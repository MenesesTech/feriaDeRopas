
package com.mycompany.presupuestoferias.models;

public class ingreso extends movimiento{
    public ingreso() {
    }
    public ingreso(String id, String type, String category, String productoServicio, int cantidad, double precio, double precioTotal, double porcentaje, double totalPrecio, String idFeria) {
        super(id, type, category, productoServicio, cantidad, precio, precioTotal, porcentaje, totalPrecio, idFeria);
    }
}
