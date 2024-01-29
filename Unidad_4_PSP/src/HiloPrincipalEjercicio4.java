
public class HiloPrincipalEjercicio4 extends Thread {
	public HiloPrincipalEjercicio4() {
		this.setName("Principal");
	}

	@Override
	public void run() {
		System.out.println("Se inicia el hilo principal!");
		ThreadEjercicio4 h1= new ThreadEjercicio4("Grupo de hilos del examen");
		ThreadEjercicio4 h2= new ThreadEjercicio4("Grupo de hilos del examen");
		ThreadEjercicio4 h3= new ThreadEjercicio4("Grupo de hilos del examen");
		System.out.println("Numero de hilos activos: "+activeCount());
		h1.start();
		h2.start();
		h3.start();
		
		
		System.out.println("Numero de hilos activos: "+activeCount());
	}
	

}
