import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Padre {

	public static void main(String[] args) {
		String dir= "C:\\Users\\EstudianteDAM204\\Desktop\\gitSegundo\\Practica_2_1ev_PSP\\src\\Hijo.java";
		String comando="";
		if(args.length>0){
			comando+=args[0];
		}
		try {
			Process p1= new ProcessBuilder("java",dir,comando).start();
			BufferedReader bf= new BufferedReader(new InputStreamReader(p1.getInputStream()));
			String linea="";
			while((linea=bf.readLine())!=null){
				System.out.println(linea);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
