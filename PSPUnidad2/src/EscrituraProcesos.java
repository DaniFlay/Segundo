import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EscrituraProcesos {

	public static void main(String[] args) {
		try {
			Process p= new ProcessBuilder("CMD","/C","DATE").start();
			OutputStream os= p.getOutputStream();
			os.write("17-01-25".getBytes());
			
			
			
			InputStream is= p.getInputStream();
			int c;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
			is.close();
			//esperar a que se acabe un proceso
			int codigo= p.waitFor();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
