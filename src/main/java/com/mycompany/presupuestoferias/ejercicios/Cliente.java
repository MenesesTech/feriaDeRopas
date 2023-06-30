/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.presupuestoferias.ejercicios;

/**
 *
 * @author Haisenberg
 */
public class Cliente {
    String nombre;
    Cliente siguiente;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }
}
