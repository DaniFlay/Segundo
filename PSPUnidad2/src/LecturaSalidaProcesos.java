import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LecturaSalidaProcesos {

	public static void main(String[] args) {
		try {
			Process p= new ProcessBuilder("CMD","/C","DIR").start();
			
			InputStream is= p.getInputStream();
			ArrayList<String> lineasSalida= new ArrayList<String>();
			int c= is.read();
			String linea="";
			while(c!=-1) {
				if(c==13) {
					lineasSalida.add(linea);
					linea="";
					
				}else {
					linea += (char)c;
				}
				c=is.read();
			}
			for(int i=5; i<lineasSalida.size();i++) {
				if(lineasSalida.get(i).contains("<DIR>")) {
					lineasSalida.remove(i);
					i--;
				}
			}
			for(int i=5; i<lineasSalida.size()-2;i++) {
				String cadenaTemp= lineasSalida.get(i);
				int ultimoEspacio= cadenaTemp.lastIndexOf(" ");
				int penultimoEspacio= (cadenaTemp.substring(0,ultimoEspacio)).lastIndexOf(" ");
				if(Integer.parseInt(cadenaTemp.substring(penultimoEspacio+1,ultimoEspacio).replace(".", ""))>100) {
					System.out.println(cadenaTemp.substring(penultimoEspacio,ultimoEspacio)+" bytes");
				}
				
				/*for(int j=0;j<listaBytes.length;j++) {
					
				}*/
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
