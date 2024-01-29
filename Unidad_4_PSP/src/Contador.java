
public class Contador {
	private int c=0;
	Contador(int c){
		this.c= c;
	}
	synchronized void incrementa() {
		c=c+1;
	}
	synchronized void decrementa() {
		c=c-1;
	}
	public int getValor() {
		return c;
	}

}
