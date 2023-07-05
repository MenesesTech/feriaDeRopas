
package com.mycompany.presupuestoferias.ejercicios;
import java.util.Scanner;

public class Recursividad {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la base: ");
        int base = scanner.nextInt();
        
        System.out.print("Ingrese el exponente: ");
        int exponente = scanner.nextInt();
        
        double resultado = calcularPotencia(base, exponente);
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("El resultado de " + base + "^" + exponente + " es: " + resultado);
        System.out.println("-------------------------------------------------------------------------");
    }
    
    public static double calcularPotencia(int base, int exponente) {

        if (exponente == 0) {
            return 1;
        }else if(exponente == 1){
            return base;
        }else if(exponente<0){
            return calcularPotencia(base, exponente+1)/base;
        }else{
            return base*calcularPotencia(base, exponente-1);
        }
    }
}
