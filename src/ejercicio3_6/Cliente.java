package ejercicio3_6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import utiles.trycatch;

public class Cliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DatagramSocket cliente = new DatagramSocket();
		trycatch t = new trycatch();
		String cadena = null;
		do {
			
		
		//DATOS DEL SERVIDOR AL QUE ENVIAR MENSAJE 
			InetAddress IPServidor = InetAddress.getLocalHost();
			int puerto=6000;
			
			//INTRODUCE DATO P
			System.out.println("Introduce una cadena:");
			 cadena= t.try_String();
			
			byte[] enviados = new byte[1024];
			enviados = cadena.getBytes();
			
			//ENVIANDO DATAGRAMA AL SERVIDOR
			DatagramPacket envio = new DatagramPacket(enviados,enviados.length, IPServidor, puerto);
			
			cliente.send(envio);

			//RECIBIENDO DATAGRAMA SERVIDOR
			cliente.setSoTimeout(4000);
			try {
				byte[] recibidos = new byte[1024];
				DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
				
				System.out.println("Esperando datagrama...");
				cliente.receive(recibo);
				String respuesta = new String( recibo.getData());
				
				System.out.println("mensaje recibido del servidor: "+respuesta);
			}catch(InterruptedIOException io) {
				System.out.println("Se han perido los paquetes");
			}
		}while(!cadena.equals("*"));
		System.out.println("Cerrando cliente...");
		cliente.close();
	
	}

}
