package ejerciciosUnidadDosPSP;

import java.io.IOException;

public class ejercicio2 {

	public static void main(String[] args) {
		if(args.length==1) {
			ProcessBuilder pb= new ProcessBuilder(args[0]);
			try {
				pb.start();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Debes introducir un argumento!");
		}

	}

}
