import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {

	public static void main(String[] args) {
		String comando; 
		if(args.length==0){
			comando= "dir";
		}
		else{
			comando="find \""+args[0]+"\" *";
		}
		
		
		try {
			Process p= new ProcessBuilder("cmd","/c",comando).start();

			BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea="";
			while((linea=bf.readLine())!=null) {
				System.out.println(linea);
			}
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
