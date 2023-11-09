import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {

	public static void main(String[] args) {
		String comandoDir= "dir";
		String comandoFind="find "+args[0]+" *";
		
		try {
			Process p= new ProcessBuilder("cmd","/c",comandoDir).start();
			Process p2= new ProcessBuilder("cmd","/c",comandoFind).start();
			BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader bf2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			String linea="";
			System.out.println("Proceso comando DIR:");
			while((linea=bf.readLine())!=null) {
				System.out.println(linea);
			}
			System.out.println("Proceso comando find: ");
			while((linea= bf2.readLine())!=null){
				System.out.println(linea);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
