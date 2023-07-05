
package com.mycompany.presupuestoferias.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese los elementos del arreglo separados por espacio:");
        String input = scanner.nextLine();
        
        String[] arrString = input.split(" ");
        int[] arr = new int[arrString.length];
        
        for (int i = 0; i < arrString.length; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Arreglo original: " + Arrays.toString(arr));
        System.out.println("-------------------------------------------------------------------------");
        shellsort(arr);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
        System.out.println("-------------------------------------------------------------------------");
    }
    
    public static void shellsort(int[] arr) {
        int n = arr.length;
        
        // Definir el tamaño del salto inicial
        int gap = n / 2;
        
        int pasada = 1;
        
        while (gap > 0) {
            // Aplicar el algoritmo de inserción en cada sublista con el tamaño de gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                arr[j] = temp;
            }
            
            System.out.println("Pasada #" + pasada + ": " + Arrays.toString(arr));
            
            // Reducir el tamaño del salto
            gap /= 2;
            pasada++;
        }
    }
}

