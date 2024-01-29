
public class HiloA extends Thread {
	private Contador contador;
	public HiloA(String n, Contador c) {
		setName(n);
		contador=c;
	}
	@Override
	public void run() {
		for(int j=0;j<300;j++) {
			contador.incrementa();
			/*try {
				sleep(10);
			} catch (InterruptedException e) {
				System.out.println("Error");
				
			}*/
		}
		System.out.println(getName()+" contador vale "+contador.getValor());
	}
	

}
