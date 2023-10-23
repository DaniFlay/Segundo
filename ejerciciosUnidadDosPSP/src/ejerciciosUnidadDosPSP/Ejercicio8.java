package ejerciciosUnidadDosPSP;

import java.io.IOException;

public class Ejercicio8 {

	public static void main(String[] args) {
		String programa= "C:\\Users\\super\\Desktop\\Segundo\\ejerciciosUnidadDosPSP\\src\\ejerciciosUnidadDosPSP\\Ejercicio7.java",arg="";
		int codigo;
		Process p;
		try {
			if(args.length>0) {
				arg= args[0];
			}
			ProcessBuilder pb= new ProcessBuilder("java",programa,arg);
			p=pb.start();
			codigo= p.waitFor();
			System.out.println("Código: "+codigo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Throwable t) {
			System.out.println(t.toString());
		}

	}

}
