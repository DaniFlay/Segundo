
public class CompartirInformacion {

	public static void main(String[] args) {
		Contador cont= new Contador(280);
		HiloA a= new HiloA("HiloA",cont);
		HiloB b= new HiloB("HiloB",cont);
		
		a.start();
		b.start();

	}

}
