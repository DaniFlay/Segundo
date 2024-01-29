
public class HiloPrioridad1 extends Thread {
	private int c=0;
	private boolean stopHilo= false;
	public HiloPrioridad1(String nombre) {
		super(nombre);
	}
	public int getContador() {
		return c;
	}
	public void pararHilo() {
		stopHilo=true;
	}
	@Override
	public void run() {
		while(!stopHilo) {
			try {
				Thread.sleep(2);
			}catch(Exception ex) {
				
			}
			c++;
		}
		System.out.println("Fin hilo "+this.getName());
	}
	

}
