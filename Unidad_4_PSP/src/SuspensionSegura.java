
public class SuspensionSegura {

	private boolean suspendido;
	public synchronized void set(boolean b) {
		suspendido =b;
		notifyAll();
	}
	public synchronized void esperaActiva() throws InterruptedException {
			while(suspendido) {
				wait();
			}

	}
}
