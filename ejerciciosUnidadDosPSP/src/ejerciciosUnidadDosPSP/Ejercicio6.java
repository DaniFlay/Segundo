package ejerciciosUnidadDosPSP;

import java.io.IOException;

public class Ejercicio6 {

	public static void main(String[] args) {
		String programa= "C:\\Users\\super\\Desktop\\Segundo\\ejerciciosUnidadDosPSP\\src\\ejerciciosUnidadDosPSP\\Ejercicio5.java";
		int codigo;
		Process p;
		String arg="";
		try {
			p = new ProcessBuilder("java",programa,args).start();
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
