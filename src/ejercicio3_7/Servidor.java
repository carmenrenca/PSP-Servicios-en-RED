package ejercicio3_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
			int numeroPuerto= 6000;
			ServerSocket servidor= new ServerSocket(numeroPuerto);
			Numeros n;
			
			
			System.out.println("Esperando al cliente...");
			Socket cliente = servidor.accept();
			//LEEMOS EL OBJETO Q NOS TRAE CLIENTE
			
			ObjectInputStream inObjeto= new ObjectInputStream(cliente.getInputStream());
			ObjectOutputStream outObjeto= new ObjectOutputStream(cliente.getOutputStream());
			do {
				
		 n = (Numeros) inObjeto.readObject();
			System.out.println("Servidor Recibe el numero: "+n.getNumero());
			
			n.setCuadrado(n.getNumero());
			n.setCubo(n.getNumero());
			
			//SE PREPARA PARA ENVIAR EL OBJETO AL CLIENTE
			
			outObjeto.writeObject(n);
			System.out.println("Envio: Cuadro "+n.getCuadrado()+" cubo: "+n.getCubo());
			}while(n.getNumero()>0);
			System.out.println("Finalizado");
			inObjeto.close();
			outObjeto.close();
			cliente.close();
			servidor.close();
			
	}

}
