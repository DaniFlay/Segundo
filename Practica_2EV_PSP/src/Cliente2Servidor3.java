import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2Servidor3 {

	public static void main(String[] args) {
		int puertoServidor1=12345;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce el número de puerto para actuar como servidor:");
		int portServer= sc.nextInt();
		System.out.println("Esperando los datos de conexión del cliente 1, que me los tiene que enviar el servidor original...");
		
		try {
			DatosConexion dc= new DatosConexion(InetAddress.getLocalHost(),portServer);
			ServerSocket server= new ServerSocket(portServer);
			Socket recepcionDatosServer1=new Socket(dc.getAddress(),dc.getPort());
			InputStream is= recepcionDatosServer1.getInputStream();
			ObjectInputStream ois= new ObjectInputStream(is);
			DatosConexion datosRecibidos= (DatosConexion) ois.readObject();
			System.out.println("\tRecibidos los datos de conexión del cliente 1, me los mandó el servidor: ");
			System.out.println(datosRecibidos.toString());
			recepcionDatosServer1.close();
			Socket cliente1= new Socket(datosRecibidos.getAddress(),puertoServidor1);
			DatosConexion servidor3= new DatosConexion(InetAddress.getLocalHost(),portServer);
			OutputStream os=null;
			ObjectOutputStream oos= new ObjectOutputStream(os);
			oos.writeObject(servidor3);
			System.out.println("\tEnvio datos de la conexión desde el cliente 2 al servidor 2:");
			System.out.println(servidor3.toString());
			oos.close();
			cliente1.close();
			System.out.println("Cerrando flujo de salida en el cliente 2...");
			System.out.println("Cliente 2 escuchando como servidor 3 en el puerto: "+servidor3.getPort());
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
