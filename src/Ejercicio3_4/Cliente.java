package Ejercicio3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import utiles.trycatch;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException   {
		// TODO Auto-generated method stub
		
		trycatch t = new trycatch();
	
		int Puerto = 6000;
		String Host="localhost";
		int cadena;
			
				System.out.println("CLIENTE INICIADO");
				
				cadena=t.try_int();
				Socket cliente= new Socket(Host, Puerto);
				
	    //FLUJO DE SALIDA AL SERVIDOR 
				
				DataOutputStream flujosalida = new DataOutputStream(cliente.getOutputStream());
		//ENVIO MENSAJE EN MINUSCULA PARA EL SERVIDOR
				
				flujosalida.write(cadena);
				
				
				flujosalida.close();
				cliente.close();
		
			
	}

}
