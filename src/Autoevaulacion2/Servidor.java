package Autoevaulacion2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import utiles.trycatch;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		trycatch t = new trycatch();
		//CREA EL SOCKET MULTICAST
		MulticastSocket ms = new MulticastSocket();
		int Puerto= 12345;
		InetAddress grupo= InetAddress.getByName("228.5.6.7");//crea grupo
		
		String cadena = "";
		while(!cadena.trim().equals("*")) {
			
			
		
		System.out.println("Datos a envuar al grupo: ");
		cadena = t.try_String();
		//ENVIANDO AL GRUPO
		
		DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(),grupo, Puerto );
		ms.send(paquete);
		}
		ms.close();
		System.out.println("Socket cerrrado");

	}

}
