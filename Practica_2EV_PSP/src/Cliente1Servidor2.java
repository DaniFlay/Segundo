import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1Servidor2 {

	public static void main(String[] args) {
		int portServer=12345;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce el puerto del servidor: ");
		int port= sc.nextInt();
		try {
			ServerSocket server= new ServerSocket(port);
			DatosConexion dc= new DatosConexion(InetAddress.getLocalHost(),port);
			Socket envioServidor1= new Socket(dc.getAddress(),portServer);
			ObjectOutputStream oos= new ObjectOutputStream(envioServidor1.getOutputStream());
			System.out.println("\tEnvio datos de la conexión desde el cliente 1 al servidor: ");
			System.out.println(dc.toString());
			
			oos.writeObject(dc);
			oos.close();
			envioServidor1.close();
			System.out.println("Cerrando flujo de salida en el cliente 1....");
			System.out.println("Cliente 1 escuchando como servidor 2 en el puerto: "+port);
			
			System.out.println("Esperando los datos de conexión del cliente 2, que me los tiene que enviar el servidor 3...");
			
			InputStream is=null;
			Socket reciboServidor3= server.accept();
			System.out.println("Recibidos los datos de la conexión con el cliente 2, me los mandó el servidor 3: ");
			is= reciboServidor3.getInputStream();
			ObjectInputStream ois= new ObjectInputStream(is);
			DatosConexion datosServer3= (DatosConexion) ois.readObject();
			System.out.println(datosServer3.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
