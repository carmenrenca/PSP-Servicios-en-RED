package Ejercicio3_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException   {
		// TODO Auto-generated method stub
		int Puerto = 6000;
		String Host="localhost";
			int cadena;
			Socket cliente;
				
				DataInputStream flujoentrada;
				//FLUJO DE ENTRADA
				do {
				 cliente= new Socket(Host, Puerto);
				
			 flujoentrada = new DataInputStream(cliente.getInputStream());
				cadena=flujoentrada.readInt();
				System.out.println("RECIBIENDO DEL SERVIDOR: \n\t"+"Soy el cliente Nº: "+cadena);
				
		
			
				}while(cadena<=6);
				flujoentrada.close();
				cliente.close();
		
			
	}

}
