package ejerciciosUnidadDosPSP;

public class Ejercicio9nuevo {

	public static void main(String[] args) {
		try {
            // Especifica el comando para ejecutar el programa SumaDosNumeros.java
            String command = "Ejercicio9.";
            

            // Ejecuta el comando
            Process process = new ProcessBuilder("java","C:\\Users\\super\\Desktop\\Segundo\\ejerciciosUnidadDosPSP\\src\\ejerciciosUnidadDosPSP\\Ejercicio9.java").start();

            // Espera a que el proceso termine
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Programa SumaDosNumeros ejecutado exitosamente.");
            } else {
                System.err.println("Error al ejecutar SumaDosNumeros. Código de salida: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
