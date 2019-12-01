package ejercicio3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import utiles.trycatch;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		trycatch t = new trycatch();
		int numero;
		InetAddress destino=InetAddress.getLocalHost();
		
		int Puerto=6000;
		

			
		
		System.out.println("PROGRAMA CLIENTE INICIADO");
		DatagramSocket cliente=new DatagramSocket(6001);
	
		
		
		
		do {
		System.out.println("Introduce un numero");
		numero=t.try_int();
		Numeros Nobject= new Numeros(numero);
		//FLUJO DE SALIDA DEL OBJETO PARA EL SERVIDOR
		ByteArrayOutputStream bs= new ByteArrayOutputStream();

		ObjectOutputStream nSal = new ObjectOutputStream(bs);
		nSal.writeObject(Nobject);
		nSal.close();

		System.out.println("Envio el numero "+Nobject.getNumero());
		byte[] envio = bs.toByteArray();
		DatagramPacket paqenvio = new DatagramPacket (envio, envio.length,destino,6000 );
		cliente.send(paqenvio);
		
		byte[] recibidos=new byte[1024];
		DatagramPacket paqrecibo= new DatagramPacket (recibidos, recibidos.length );
		cliente.receive(paqrecibo);
		ByteArrayInputStream bais= new ByteArrayInputStream(recibidos);
		ObjectInputStream nEnt= new ObjectInputStream(bais);

		Nobject = (Numeros)nEnt.readObject();
	
		System.out.println("El cuadrado del numero es : "+Nobject.getCuadrado()+" El cubo es: "+Nobject.getCubo());
		nEnt.close();
		}while(numero>0);
		System.out.println("Cliente Finalizado");
	
		
		cliente.close();
		
	}

}
