package primerEjercicio;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;


public class ejercicio2 {
	
	public boolean ejercicio2() throws IOException {
		File f = new File("C:\\Users\\EstudianteDAM204\\Desktop");
		File[] lista = f.listFiles();
		boolean devolucion= true;
		String tipo;
		for (int i=0; i<lista.length;i++) {
			BasicFileAttributes att= Files.readAttributes(lista[i].toPath(), BasicFileAttributes.class);
			if (lista[i].isDirectory()) {
				tipo= "Directorio";
				File[] sublista= lista[i].listFiles();
				System.out.println("Archivo tipo: "+tipo+"\nNombre: "+lista[i].getName()+"\nÚltima modificación: "+att.lastModifiedTime()+"\nTamaño: "+lista[i].length()+"\nNº de archivos dentro: "+sublista.length);
			}
			else {
				tipo="Archivo"; 
				System.out.println("Archivo tipo: "+tipo+"\nNombre: "+lista[i].getName()+"\nÚltima modificación: "+att.lastModifiedTime()+"\nExtensión: "+FilenameUtils.getExtension(lista[i].getName())+"\nTamaño: "+lista[i].length());
			}
			
		}
		return devolucion;
	}
	
}

