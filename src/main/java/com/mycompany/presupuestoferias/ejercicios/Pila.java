/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.presupuestoferias.ejercicios;

/**
 *
 * @author Haisenberg
 */
public class Pila {
    private int[] arreglo;
    private int tamaño;
    private int tope;

    public Pila() {
        tamaño = 100; // Tamaño predeterminado
        arreglo = new int[tamaño];
        tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == tamaño - 1;
    }

    public void agregar(int dato) {
        if (estaLlena()) {
            System.out.println("La pila está llena. No se puede agregar más elementos.");
        } else {
            tope++;
            arreglo[tope] = dato;
            System.out.println("Se agregó el elemento a la pila.");
        }
    }

    public void quitar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
        } else {
            int dato = arreglo[tope];
            tope--;
            System.out.println("Se quitó el elemento de la pila: " + dato);
        }
    }

    public int getTamaño() {
        return tope + 1;
    }

    public String mostrarDatos() {
        StringBuilder sb = new StringBuilder();
        if (estaVacia()) {
            sb.append("La pila está vacía.");
        } else {
            sb.append("Datos en la pila:\n");
            for (int i = tope; i >= 0; i--) {
                sb.append(arreglo[i]).append("\n");
            }
        }
        return sb.toString();
    }
}
