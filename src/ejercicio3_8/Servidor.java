package ejercicio3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
			int numeroPuerto= 6000;
			DatagramSocket servidor = new DatagramSocket(numeroPuerto);
			
			Numeros n;
			InetAddress destino=InetAddress.getLocalHost();

			
			System.out.println("Esperando al cliente...");
			//LEEMOS EL OBJETO Q NOS TRAE CLIENTE
			byte[] buffer = new byte[1024];

			do {
				DatagramPacket recibo= new DatagramPacket(buffer, buffer.length);
				servidor.receive(recibo);
				ByteArrayInputStream bais=new ByteArrayInputStream(buffer);
				ObjectInputStream inObjeto= new ObjectInputStream(bais);

		 n = (Numeros) inObjeto.readObject();
			System.out.println("Servidor Recibe el numero: "+n.getNumero());
			inObjeto.close();
			n.setCuadrado(n.getNumero());
			n.setCubo(n.getNumero());
		
			//SE PREPARA PARA ENVIAR EL OBJETO AL CLIENTE
			ByteArrayOutputStream bs=new ByteArrayOutputStream();
			ObjectOutputStream outObjeto= new ObjectOutputStream(bs);
			
			outObjeto.writeObject(n);
			outObjeto.close();
			
			byte[] mensaje=bs.toByteArray();
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,6001);
			servidor.send(envio);
			
			System.out.println("Envio: Cuadro "+n.getCuadrado()+" cubo: "+n.getCubo());
			}while(n.getNumero()>0);
			System.out.println("Finalizado");
		
		
			servidor.close();
			
	}

}
