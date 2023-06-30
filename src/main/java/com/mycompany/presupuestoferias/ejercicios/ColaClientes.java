package com.mycompany.presupuestoferias.ejercicios;

public class ColaClientes {

    private Cliente inicio;
    private Cliente fin;
    private int tamaño;

    public ColaClientes() {
        this.inicio = null;
        this.fin = null;
        this.tamaño = 0;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public void agregarCliente(String nombre) {
        Cliente nuevoCliente = new Cliente(nombre);

        if (estaVacia()) {
            inicio = nuevoCliente;
            fin = nuevoCliente;
        } else {
            fin.siguiente = nuevoCliente;
            fin = nuevoCliente;
        }

        tamaño++;
        System.out.println("Se agregó el cliente " + nombre + " a la cola.");
    }

    public void quitarCliente() {
        if (estaVacia()) {
            System.out.println("La cola de clientes está vacía.");
        } else {
            String nombreCliente = inicio.nombre;
            inicio = inicio.siguiente;
            tamaño--;
            System.out.println("Se quitó el cliente " + nombreCliente + " de la cola.");
        }
    }

    public int getTamaño() {
        return tamaño;
    }

    public String mostrarClientes() {
        StringBuilder sb = new StringBuilder();
        if (estaVacia()) {
            sb.append("La cola de clientes está vacía.");
        } else {
            sb.append("Clientes en la cola: ");
            Cliente actual = inicio;
            while (actual != null) {
                sb.append(actual.nombre);
                if (actual.siguiente != null) {
                    sb.append(", ");
                }
                actual = actual.siguiente;
            }
        }
        return sb.toString();
    }

}
