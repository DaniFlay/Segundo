package ejerciciosUnidadDosPSP;

public class Ejercicio5 {

	public static void main(String[] args) {
		if(args.length!=1) {
			System.exit(-1);
		}
		else {
			System.out.println(Math.pow(Double.parseDouble(args[0]), 3));
			System.exit(1);
		}

	}

}
