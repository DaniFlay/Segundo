import java.io.Serializable;
import java.net.InetAddress;

public class DatosConexion implements Serializable{
	private InetAddress address;
	private int port;
	public InetAddress getAddress() {
		return address;
	}
	public void setAddress(InetAddress address) {
		this.address = address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public DatosConexion(InetAddress address, int port) {
		super();
		this.address = address;
		this.port = port;
	}
	public DatosConexion() {
		super();
	}
	@Override
	public String toString() {
		return "\t\tInetAddress: " + address + "\n\t\tPuerto: " + port;
	}
	
	
	
}
