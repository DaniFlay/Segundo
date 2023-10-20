import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaDatosTeclado {

	public static void main(String[] args) {
		InputStreamReader iSR= new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(iSR);
		String texto;
		
		System.out.println("Introduce una cadena de texto: ");
		try {
			texto= br.readLine();
			System.out.println("Cadena: "+texto+"\nLongitud: "+texto.length());
			iSR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
