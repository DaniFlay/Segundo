
public class HiloSimple_LLamada {

	public static void main(String[] args) {
		HiloSimple_Thread hilo= new HiloSimple_Thread();
		hilo.start();
		System.out.println("Soy la clase que inicia el hilo");

	}

}
