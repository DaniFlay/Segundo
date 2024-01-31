import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor1 {

	public static void main(String[] args) {
		int port=12345;
		try {
			ServerSocket server= new ServerSocket(port);
			Socket reciboDelCliente1Servidor2= null;
			System.out.println("El servidor original escuchando en el puerto: "+server.getLocalPort());
			System.out.println("Esperando los datos del cliente 1: ");
			reciboDelCliente1Servidor2=server.accept();
			System.out.println("\tRecibiendo datos del cliente 1:");
			InputStream is1=null;
			is1= reciboDelCliente1Servidor2.getInputStream();
			ObjectInputStream ois= new ObjectInputStream(is1);
			DatosConexion datosCliente1Servidor2=(DatosConexion) ois.readObject();
			System.out.println(datosCliente1Servidor2.toString());
			reciboDelCliente1Servidor2.close();
			is1.close();
			System.out.println("Cerrando flujo de entrada...");
			System.out.println("Cerrando conexión con el cliente 1...");
			System.out.println("Abriendo conexión con el cliente 2 para enviarle los datos del cliente 1...");
			Socket envioAlCliente2= null;
			envioAlCliente2= server.accept();
			System.out.println("\tEnvio datos de la conexión desde el servidor al cliente2: ");
			System.out.println(datosCliente1Servidor2.toString());
			OutputStream os=null;
			ObjectOutputStream oos= new ObjectOutputStream(os);
			oos.writeObject(datosCliente1Servidor2);
			System.out.println("Cerrando conexión con el cliente 2....");
			System.out.println("Cerrando el servidor original....");
			oos.close();
			envioAlCliente2.close();
			server.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
