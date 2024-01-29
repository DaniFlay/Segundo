
public class HiloSimple_Thread2 extends Thread {
	private int iteraciones;
	
	HiloSimple_Thread2 (int n){
		this.iteraciones= n;
	}
	

	@Override
	public void run() {
		for( int i=0; i<iteraciones;i++) {
			System.out.println("Soy un hilo que solo escribe lineas de texto. Esta es la iteracion nº"+(i+1));
		}
	}


	public static void main(String[] args) {
		HiloSimple_Thread2 hilo= new HiloSimple_Thread2(10);
		hilo.start();

	}

}
