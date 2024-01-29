
public class MatarHilo extends Thread {
	private boolean pararHilo= false;
	
	public void pararHilo() {
		pararHilo= true;
	}
	

	@Override
	public void run() {
		while(!pararHilo) {
			System.out.println("Dentro del hilo");
		}
	}


	public static void main(String[] args) {
		MatarHilo h= new MatarHilo();
		h.start();
		for(int i=0; i<300000;i++) {
			
		}
		h.pararHilo();

	}

}
