
public class GestionPrioridadesSimpe extends Thread {
	GestionPrioridadesSimpe(String nom){
		this.setName(nom);
	}
	
	
	@Override
	public void run() {
		System.out.println("Ejecutando ["+getName()+"]");
		for(int i=0;i<=5;i++) {
			System.out.println("\t("+getName()+": "+i+")");
		}
	}


	public static void main(String[] args) {
		GestionPrioridadesSimpe h1= new GestionPrioridadesSimpe("Uno");
		GestionPrioridadesSimpe h2= new GestionPrioridadesSimpe("Dos");
		GestionPrioridadesSimpe h3= new GestionPrioridadesSimpe("Tres");
		GestionPrioridadesSimpe h4= new GestionPrioridadesSimpe("Cuatro");
		GestionPrioridadesSimpe h5= new GestionPrioridadesSimpe("Cinco");
		
		h1.setPriority(Thread.MIN_PRIORITY);
		h2.setPriority(3);
		h3.setPriority(Thread.NORM_PRIORITY);
		h4.setPriority(7);
		h5.setPriority(Thread.MAX_PRIORITY);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();

	}

}
