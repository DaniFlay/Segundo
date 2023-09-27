package primerEjercicio;

import java.io.File;
import java.io.IOException;

public class primerEjercicio {

	public static void main(String[] args) throws IOException {
		ejercicio2 ej= new ejercicio2();
		ej.ejercicio2();

	}
	public static void ejercicio1() throws IOException{
	    File f= new File("C:/Users/EstudianteDAM204/Desktop/elnombrequequerais");
	    System.out.println("Probando el método getName");
	    String nombre= f.getName();
	    System.out.println("Este método devuelve el nombre del archivo, en este caso el nombre es: "+nombre);
	    System.out.println("Probando el método getPath");
	    String ruta= f.getPath();
	    System.out.println("Este método devuelve la ruta del archivo, en este caso la ruta es: "+ruta);
	    System.out.println("Probando el método isFile");
	    boolean existencia= f.isFile();
	    System.out.println("Este método devuelve true si el archivo es un archivo normal y false si se trata de un directorio, en este caso el resultado es: "+existencia);
	    System.out.println("Probando el método length");
	    long longitud= f.length();
	    System.out.println("Esté método devuelve la longitud de un archivo, en este caso es: "+longitud);
	    System.out.println("Probando el método createNewFile");
	    File f2= new File("C:/Users/EstudianteDAM204/Desktop/elnombrequequerais2");
	    boolean creacion = f2.createNewFile();
	    System.out.println("Este método crea un archivo vacío en el caso de no exisitir, y devuelve true en el caso de que el archivo se haya creado con éxito, y false en el caso contrario, en este caso el resultado es: "+creacion);
	}
}
