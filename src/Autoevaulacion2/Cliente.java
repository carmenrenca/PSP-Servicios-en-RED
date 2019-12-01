package Autoevaulacion2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		//CREA SOCKET MULTICAST
		
		int puerto= 12345;
		MulticastSocket ms = new MulticastSocket(puerto);
		InetAddress grupo= InetAddress.getByName("228.5.6.7");//crea grupo
		
		//nos unimos al grupo
		
		ms.joinGroup(grupo);
		
		String msg="";
		while(!msg.trim().equals("*")) {
			
		
		byte[]buf = new byte[1000];
		//recive el parque del servidor multicast 
		
		DatagramPacket paquete = new DatagramPacket(buf, buf.length);
		ms.receive(paquete);
		
		msg= new String (paquete.getData());
		
		System.out.println("Recibo: "+msg);
		}
		ms.leaveGroup(grupo);
		ms.close();
		System.out.println("Socket cerrado");
		
	}

}
