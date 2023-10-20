import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class RedireccionProcesos {

	public static void main(String[] args) {
		
		
		
		
		ProcessBuilder pb= new ProcessBuilder("CMD","/C","TASKLIST");
		pb.redirectOutput(Redirect.INHERIT);
	
		pb.redirectOutput(Redirect.to(Fichero));
		pb.redirectOutput(Redirect.appendTo(Fichero));
		
		pb.redirectInput(Redirect.from(Fichero));
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //HERENCIA
		
		/*ProcessBuilder pb=new ProcessBuilder("CMD");
		File ficheroComandos= new File("C:\\Users\\EstudianteDAM204\\eclipse-workspace\\PSPUnidad2\\src\\comandos.bat");
		File ficheroSalida= new File("salidaComandos.txt");
		File ficheroErrores= new File("salidaErrores.txt");
		pb.redirectInput(ficheroComandos);
		pb.redirectOutput(ficheroSalida);
		pb.redirectError(ficheroErrores);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
