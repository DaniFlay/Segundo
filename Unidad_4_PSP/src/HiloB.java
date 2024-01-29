
public class HiloB extends Thread {
	private Contador contador;
	public HiloB(String n, Contador c) {
		setName(n);
		contador=c;
	}
	@Override
	public void run() {
		for(int j=0;j<300;j++) {
			contador.decrementa();
		try {
			sleep(10);
		}catch(InterruptedException e) {
			
		}
		}
		System.out.println(getName()+" contador vale "+contador.getValor());
	}
	

}
