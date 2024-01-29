
public class HiloSimple_Thread_Varios extends Thread {
	public HiloSimple_Thread_Varios(String nombre) {
		super(nombre);
		System.out.println("Se ha creado el hilo"+getName()+".");
	}
	

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hilo:"+getName()+". Iteracion: "+i+".");
		}
	}


	public static void main(String[] args) {
		HiloSimple_Thread_Varios h1= new HiloSimple_Thread_Varios("1");
		HiloSimple_Thread_Varios h2= new HiloSimple_Thread_Varios("2");
		HiloSimple_Thread_Varios h3= new HiloSimple_Thread_Varios("3");
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("Se han creado 3 hilos");

	}

}
