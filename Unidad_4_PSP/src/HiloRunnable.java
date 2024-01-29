
public class HiloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Soy un hilo Runnable");
		Thread.currentThread().getId();

	}

}
