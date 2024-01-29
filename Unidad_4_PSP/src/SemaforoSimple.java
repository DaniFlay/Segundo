import java.util.concurrent.Semaphore;

public class SemaforoSimple {
	private static HiloSemaforos hilos[];
	private static Semaphore semaforo= new Semaphore(1);
	
	

	public static void main(String[] args) {
		int totalHilos=10;
		hilos= new HiloSemaforos[totalHilos];
		
		for(int i=0; i<totalHilos;i++) {
			hilos[i]= new HiloSemaforos(1000000,i,semaforo);
			hilos[i].start();
		}
		for(int i=0; i<totalHilos;i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Contador: "+Contador3.cuenta);

	}

}
