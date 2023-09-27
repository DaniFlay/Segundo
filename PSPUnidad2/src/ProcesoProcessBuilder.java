import java.io.IOException;

public class ProcesoProcessBuilder {

	public static void main(String[] args) {
		ProcessBuilder pb;
		pb = new ProcessBuilder("C:\\Windows\\System32\\notepad.exe"); //inicializar el ProcessBuilder
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
