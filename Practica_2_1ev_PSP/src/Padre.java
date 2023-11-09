import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Padre {

	public static void main(String[] args) {
		String dir= "C:\\Users\\EstudianteDAM204\\Desktop\\gitSegundo\\Practica_2_1ev_PSP\\src\\Hijo.java";
		String find= "C:\\Users\\EstudianteDAM204\\Desktop\\gitSegundo\\Practica_2_1ev_PSP\\src\\Hijo.java find "+args[0]+ " *";
		try {
			Process p1= new ProcessBuilder("java",dir,"dir").start();
			Process p2= new ProcessBuilder("java",dir, find).start();
			BufferedReader bf= new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader bf2= new BufferedReader(new InputStreamReader(p2.getInputStream()));
			String linea="";
			while((linea=bf.readLine())!=null){
				System.out.println(linea);
			}
			while ((linea=bf2.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
