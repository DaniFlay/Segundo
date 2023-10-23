package ejerciciosUnidadDosPSP;

import java.io.IOException;
import java.io.InputStream;

public class Ejercicio4 {

	public static void main(String[] args) {
		try {
			Process p= new ProcessBuilder("cmd","/c","dir").start();
			InputStream is= p.getInputStream();
			int q;
			String linea="";
			while((q=is.read())!=-1) {
				linea+=(char)q;
				if(q==10) {
					if(linea.contains("<DIR>")) {
						System.out.println(linea);
					}
					linea="";
				}
				
				
				
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
