package ejercicio3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
	int Puerto = 6000;
	String Host="localhost";

	ServerSocket Servidor = new ServerSocket(Puerto);
	
	Socket Cliente1 = Servidor.accept();

	System.out.println("Cliente 1  en el puerto: "+Cliente1.getLocalPort());

	Socket Cliente2= Servidor.accept();
	
	System.out.println("Cliente 2 en el puerto: "+Cliente1.getLocalPort());
	Servidor.close();
	}
}
