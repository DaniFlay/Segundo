import java.io.IOException;

public class Padre {

	public static void main(String[] args) {
		String dir= "Hijo";
		String find= "Hijo find /v /c \"\" C:\\Users\\EstudianteDAM204\\Desktop\\*.txt";
		try {
			Process p1= new ProcessBuilder("java",dir,"dir").start();
			Process p2= new ProcessBuilder("java",dir, find).start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
