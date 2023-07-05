
package com.mycompany.presupuestoferias.models;

public class egreso extends movimiento{

    public egreso() {
    }

    public egreso(String id, String type, String category, String productoServicio, int cantidad, double precio, double precioTotal, double porcentaje, double totalPrecio, String idFeria) {
        super(id, type, category, productoServicio, cantidad, precio, precioTotal, porcentaje, totalPrecio, idFeria);
    }
}
