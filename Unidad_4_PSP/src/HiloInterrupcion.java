
public class HiloInterrupcion extends Thread {
	

	@Override
	public void run() {
		while(!isInterrupted()) {
			System.out.println("Dentro del hilo"+System.currentTimeMillis());
		}
		System.out.println("Ha ocurrido una interrupcion");
	}
	public void interrumpir() {
		interrupt();
	}

	public static void main(String[] args) {
		HiloInterrupcion h= new HiloInterrupcion();
		h.start();
		for(int i=0;i<100000;i++) {
			
		}
		h.interrumpir();

	}

}
