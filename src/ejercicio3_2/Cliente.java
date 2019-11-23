package ejercicio3_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws IOException {
	int Puerto = 6000;
	String Host="localhost";
	
	Socket Cliente = new Socket(Host, Puerto);
	
	InetAddress i = Cliente.getInetAddress();
	
	System.out.println("Puerto local: "+Cliente.getLocalPort());
	System.out.println("Puerto Remoto: "+Cliente.getPort());
	System.out.println("Nombre del Host/IP: "+Cliente.getInetAddress());
	System.out.println("Host Remoto: "+i.getHostName());
	System.out.println("IP Host Remoto. "+i.getHostAddress().toString());
	
	Cliente.close();
	
	}
	
}
