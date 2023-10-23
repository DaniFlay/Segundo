package ejerciciosUnidadDosPSP;

import java.io.IOException;

public class Ejercicio6 {

	public static void main(String[] args) {
		Double numero= Double.parseDouble(args[0]);
		String programa= "java Ejercicio5 "+numero;
		int codigo;
		Process p;
		try {
			p = new ProcessBuilder(programa).start();
			codigo= p.waitFor();
			System.out.println("Código: "+codigo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
