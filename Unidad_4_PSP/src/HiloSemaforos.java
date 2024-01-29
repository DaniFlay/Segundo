import java.util.concurrent.Semaphore;

class Contador3{
	public static int cuenta=0;
}
class HiloSemaforos extends Thread {
	private int cuentaHilo;
	private Semaphore semaforo;
	
	HiloSemaforos(int fin, int id, Semaphore s){
		this.cuentaHilo= fin;
		this.semaforo= s;
	}
	public void incremento() {
		Contador3.cuenta++;
	}
	@Override
	public void run() {
		for(int i=0; i<cuentaHilo;i++) {
			try {
				semaforo.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			incremento();
			semaforo.release();
		}
	}
	

}
