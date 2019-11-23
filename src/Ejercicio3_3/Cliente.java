package Ejercicio3_3;

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
			String cadena;
			
				System.out.println("CLIENTE INICIADO");
				Socket cliente= new Socket(Host, Puerto);
				
				//FLUJO DE ENTRADA
				
				DataInputStream flujoentrada = new DataInputStream(cliente.getInputStream());
				cadena=flujoentrada.readUTF();
				System.out.println("RECIBIENDO DEL SERVIDOR: \n\t"+cadena);
				
		//FLUJO DE SALIDA AL SERVIDOR 
				
				DataOutputStream flujosalida = new DataOutputStream(cliente.getOutputStream());
		//ENVIO MENSAJE EN MINUSCULA PARA EL SERVIDOR
				
				flujosalida.writeUTF(cadena.toLowerCase());
				
				flujoentrada.close();
				flujosalida.close();
				cliente.close();
		
			
	}

}
