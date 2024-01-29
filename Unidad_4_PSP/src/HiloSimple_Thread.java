
public class HiloSimple_Thread extends Thread {
	@Override
	public void run() {
		for (int i=0; i<4;i++) {
			System.out.println("Soy el hilo que solo escribe lineas de texto. Es la iteracion nº"+(i+1));
		}
			
			
	}

	public static void main(String[] args) {
		HiloSimple_Thread hilo= new HiloSimple_Thread();
		hilo.start();

		
	}

}
