//
package com.mycompany.presupuestoferias.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese los elementos del arreglo separados por espacio: ");
        String input = scanner.nextLine();
        
        String[] arrString = input.split(" ");
        int[] arr = new int[arrString.length];
        
        for (int i = 0; i < arrString.length; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Arreglo original: " + Arrays.toString(arr));
        System.out.println("-------------------------------------------------------------------------");
        
        quicksort(arr, 0, arr.length - 1);
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
        System.out.println("-------------------------------------------------------------------------");
    }
    
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            
            System.out.println("Pivote: " + arr[pivotIndex]);
            System.out.println("Arreglo parcial: " + Arrays.toString(arr));
            
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        
        swap(arr, low, i - 1);
        
        return i - 1;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
