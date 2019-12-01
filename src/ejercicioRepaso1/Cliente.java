package ejercicioRepaso1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import utiles.trycatch;

public class Cliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		trycatch t = new trycatch();
		
		int Puerto = 6000;
		String Host="localhost";
		String cadena = null;
		
			
		
			do {
				
			
				System.out.println("CLIENTE INICIADO");
				System.out.println("Introduzca una cadena de caracteres");
				cadena=t.try_String();
				Socket cliente= new Socket(Host, Puerto);
				
	    //FLUJO DE SALIDA AL SERVIDOR 
				
				DataOutputStream flujosalida = new DataOutputStream(cliente.getOutputStream());
		//ENVIO MENSAJE EN MINUSCULA PARA EL SERVIDOR
				
				flujosalida.writeUTF(cadena);
				

				//FLUJO DE ENTRADA
				if(!cadena.equalsIgnoreCase("*")) {
					
				
				DataInputStream flujoentrada = new DataInputStream(cliente.getInputStream());
				cadena=flujoentrada.readUTF();
				System.out.println("RECIBIENDO DEL SERVIDOR : \n\t"+cadena);
				
				
				flujosalida.close();
				flujoentrada.close();
				cliente.close();
				}else {
					System.out.println("Finalizando Cliente");
				}
			}while(!cadena.equalsIgnoreCase("*"));
			
		
			System.out.println("Saliendo..");
	}

}
