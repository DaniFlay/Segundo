import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProgramaDos {

	public static void main(String[] args) {
		File f= new File(".\\bin");
		ProcessBuilder pb= new ProcessBuilder("java","LecturaDatosTeclado");
		pb.directory(f);
		try {
			Process p= pb.start();
			OutputStream os= p.getOutputStream();
			os.write("Hello\n".getBytes());
			os.flush();
			
			InputStream is= p.getInputStream();
			int c;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
				}

	}
