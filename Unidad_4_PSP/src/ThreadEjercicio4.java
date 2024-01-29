
public class ThreadEjercicio4 extends Thread {
	private String grupo;
	public ThreadEjercicio4(String grupo) {
		this.grupo=grupo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(10);
			System.out.println("Informacion del hilo:");
			System.out.println("\nID hilo: "+this.getId());
			System.out.println("\nPrioridad: "+this.getPriority());
			System.out.println("\nGrupo: "+this.getGrupo());
		}catch(Exception ex) {
			
		}
		
		System.out.println("Hilo finalizado");
	}
	

}
