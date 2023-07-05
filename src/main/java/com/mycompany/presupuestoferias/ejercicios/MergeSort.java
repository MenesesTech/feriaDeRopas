
package com.mycompany.presupuestoferias.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    private static int paso = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa los elementos separados por espacios: ");
        String input = scanner.nextLine();
        String[] items = input.split(" ");

        int[] array = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            array[i] = Integer.parseInt(items[i]);
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Lista original: " + Arrays.toString(array));
        System.out.println("-------------------------------------------------------------------------");
        mergeSort(array);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Lista ordenada: " + Arrays.toString(array));
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);
    }

    public static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        System.out.println("Paso #" + paso++ + ": " + Arrays.toString(left) + " - " + Arrays.toString(right) + " -> " + Arrays.toString(result));
    }
}

