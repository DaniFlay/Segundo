package ejerciciosUnidadDosPSP;

public class Ejercicio7 {

	public static void main(String[] args) {
		if(args.length==0) {
			System.exit(1);
		}
		else if(Double.parseDouble(args[0])<10 && Double.parseDouble(args[0])>0) {
			System.exit(3);
		}
		else if(args[0] instanceof String) {
			System.exit(2);
		}
		else {
			System.exit(0);
		}

	}

}
