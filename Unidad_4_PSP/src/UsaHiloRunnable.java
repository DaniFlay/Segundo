
public class UsaHiloRunnable {

	public static void main(String[] args) {
		//Manera 1
		HiloRunnable hilo1= new HiloRunnable();
		new Thread(hilo1).start();
		
		//Manera 2
		HiloRunnable hilo2= new HiloRunnable();
		Thread hilo= new Thread(hilo2);
		
		hilo.start();
		
		//Manera 3
		new Thread(new HiloRunnable()).start();

	}

}
