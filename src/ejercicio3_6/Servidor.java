package ejercicio3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import utiles.trycatch;

public class Servidor {

	public static void main(String[] args) throws IOException {
	trycatch t = new trycatch();
	String mensaje;
	DatagramSocket socket = new DatagramSocket(6000);

	do {
		
	
		
		//Esperando datagrama
		
		System.out.println("Esperando datagrama cliente....");
		
		DatagramPacket recibo;
		byte[] buffer = new byte[1024];
		recibo= new DatagramPacket(buffer, buffer.length);
		socket.receive(recibo);
		
		 mensaje= new String(recibo.getData()).trim();
		System.out.println("Servidor recibe: "+mensaje);
		
	
		
		//DIRECCION ORIGEN DEL MENSAJE
		InetAddress IPOrigen = recibo.getAddress();
		int puerto = recibo.getPort();
		
		//EVIANDO DATAGRAMA AL CLIENTE
		
		mensaje= mensaje.toUpperCase();
		byte[] enviados = new byte[1024];
		enviados = mensaje.getBytes();
		
		
		DatagramPacket envio = new DatagramPacket(enviados,enviados.length, IPOrigen, puerto);
		
		socket.send(envio);
	}while(!mensaje.equals("*"));
		//CERRAR SOCKET
		System.out.println("Cerrando conexion...");
		socket.close();
			
	}

}
