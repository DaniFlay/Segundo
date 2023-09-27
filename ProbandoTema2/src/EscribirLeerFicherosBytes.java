import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirLeerFicherosBytes {

	public static void main(String[] args) throws IOException {
		File f= new File("C:\\Users\\EstudianteDAM204\\Desktop\\ficheroBytes.dat");
		
		FileOutputStream fileout= new FileOutputStream(f,true);
		
		FileInputStream filein= new FileInputStream(f);
		
		int i;
		
		for (i=1;i<100;i++) {
			fileout.write(i);
		}
		fileout.close();
		
		while((i=filein.read())!=-1){
			System.out.println(i);
		}
		filein.close();
	}

}
