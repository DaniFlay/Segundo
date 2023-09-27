import java.io.IOException;

public class ProcesoRuntime {

	public static void main(String[] args) {
		String rutaPrograma="C:\\Windows\\System32\\notepad.exe";
		Runtime r;
		r= Runtime.getRuntime();
		try {
			r.exec(rutaPrograma);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
