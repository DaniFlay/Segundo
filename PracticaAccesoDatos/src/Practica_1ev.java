import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica_1ev {

	public static void main(String[] args) {
		String rutaCarpetaCompartida="C:\\Users\\EstudianteDAM204\\Desktop\\CarpetaCompartida";
		carpetaReubicacion();

	}
	public static int carpetaReubicacion() {
		int exito=0;
		String s="",ruta="";
		while(exito==0) {
			Scanner sc= new Scanner(System.in);
			System.out.println("Introduce la ruta para la reubicación de los archivos: ");
			ruta=sc.nextLine();
			if(ruta.equals(s)) {
				
				System.out.println("Debes introducir una ruta!");
			}
			else {
				exito=1;
			}
		}
		crearCarpetas(ruta);
		return exito;
	}
	public static int crearCarpetas(String ruta) {
		int exito=0;
		String[] nombresCarpetas= {"clientes","empleados","sucursales","pedidos","detalleDeLosPedidos","productos","proveedores"};
		for(int i=0; i<nombresCarpetas.length;i++) {
			File f= new File(ruta+"\\"+nombresCarpetas[i]);
			if(!f.exists()) {
				f.mkdirs();
			}
		}
		return exito;
	}
	public static int analisisCarpeta(String ruta) {
		ArrayList<File> dat= new ArrayList<File>();;
		ArrayList<File> xml= new ArrayList<File>();
		ArrayList<File> txt= new ArrayList<File>();
		File f= new File(ruta);
		if(f.exists()) {
			File[] archivos= f.listFiles();
			for(int i=0;i<archivos.length;i++) {
				if(archivos[i].isDirectory()) {
					analisisCarpeta(archivos[i].getAbsolutePath());
				}
				else if(archivos[i].isFile()) {
					if(archivos[i].getName().contains(".dat")) {
						dat.add(archivos[i]);
					}
					else if(archivos[i].getName().contains(".xml")) {
						xml.add(archivos[i]);
					}
					else if(archivos[i].getName().contains(".txt")) {
						txt.add(archivos[i]);
					}
				}
			}
		}
	}

}
