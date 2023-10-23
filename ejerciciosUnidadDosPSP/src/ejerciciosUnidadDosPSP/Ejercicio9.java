package ejerciciosUnidadDosPSP;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        System.out.print("Introduce el primer número: ");
	        if (input.hasNextDouble()) {
	            double numero1 = input.nextDouble();
	            input.nextLine();  // Consumir el salto de línea

	            System.out.print("Introduce el segundo número: ");
	            if (input.hasNextDouble()) {
	                double numero2 = input.nextDouble();

	                double suma = numero1 + numero2;
	                System.out.println("La suma de " + numero1 + " y " + numero2 + " es: " + suma);
	            } else {
	                System.err.println("El segundo valor introducido no es un número válido.");
	            }
	        } else {
	            System.err.println("El primer valor introducido no es un número válido.");
	        }

	        input.close();
	    


	}

}
