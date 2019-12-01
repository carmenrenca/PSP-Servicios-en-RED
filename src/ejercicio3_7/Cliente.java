package ejercicio3_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import utiles.trycatch;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		trycatch t = new trycatch();
		int numero;
		String Host= "localhost";
		int puerto= 6000;
		
			
		
		System.out.println("PROGRAMA CLIENTE INICIADO");
		Socket cliente= new Socket(Host, puerto);
		//FLUJO DE SALIDA DEL OBJETO PARA EL SERVIDOR
		
		ObjectOutputStream nSal = new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream nEnt= new ObjectInputStream(cliente.getInputStream());
		do {
		System.out.println("Introduce un numero");
		numero=t.try_int();
		Numeros Nobject= new Numeros(numero);
		nSal.writeObject(Nobject);
		System.out.println("Envio el numero "+Nobject.getNumero());
		
		Nobject = (Numeros)nEnt.readObject();
		System.out.println("El cuadrado del numero es : "+Nobject.getCuadrado()+" El cubo es: "+Nobject.getCubo());
		
		}while(numero>0);
		System.out.println("Cliente Finalizado");
		nSal.close();
		nEnt.close();
		cliente.close();
		
	}

}
