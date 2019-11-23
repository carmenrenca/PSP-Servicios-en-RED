package ejercicio3_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		int Puerto = 6000;
		String Host="localhost";
		
		Socket Cliente2 = new Socket(Host, Puerto);
		
		InetAddress i = Cliente2.getInetAddress();
		
		System.out.println("Puerto local: "+Cliente2.getLocalPort());
		System.out.println("Puerto Remoto: "+Cliente2.getPort());
		System.out.println("Nombre del Host/IP: "+Cliente2.getInetAddress());
		System.out.println("Host Remoto: "+i.getHostName());
		System.out.println("IP Host Remoto. "+i.getHostAddress().toString());
		
		Cliente2.close();
	}

}
