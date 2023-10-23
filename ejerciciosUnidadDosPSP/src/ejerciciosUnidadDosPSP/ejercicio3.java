package ejerciciosUnidadDosPSP;

import java.io.IOException;

public class ejercicio3 {

	public static void main(String[] args) {
		ProcessBuilder pb= new ProcessBuilder(args[0]);
		try {
			Process p=pb.start();
			Thread.sleep(5000);
			p.destroy();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
