import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloSuspender extends Thread {
	public SuspensionSegura s = new SuspensionSegura();
	public void suspenderHilo() {
		s.set(true);
	}
	public void reanudar() {
		s.set(false);
	}
	

	@Override
	public void run() {
		try {
			for(int i=0;i<10;i++) {
				System.out.println(this.getName()+"Hilo en ejecucion..."+i);
				s.esperaActiva();
			}
		}catch(InterruptedException ex) {
			Logger.getLogger(HiloSuspender.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	public static void main(String[] args) {
		HiloSuspender hilo= new HiloSuspender();
		hilo.start();
		System.out.println("Hilo iniciado");
		hilo.suspenderHilo();
		System.out.println("Hilo suspendido");
		hilo.reanudar();
		System.out.println("Hilo renaudado");
		
		HiloSuspender hilo2= new HiloSuspender();
		hilo2.start();
		System.out.println("Hilo iniciado");
		hilo2.suspenderHilo();
		System.out.println("Hilo suspendido");
		hilo2.reanudar();
		System.out.println("Hilo renaudado");
		

	}

}
