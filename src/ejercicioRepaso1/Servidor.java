package ejercicioRepaso1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.IIOException;

import utiles.utilescarmen;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			int puerto=6000;
			ServerSocket servidor= null;
			String n;
			int caracteres;
			utilescarmen util= new utilescarmen();
			try {
				do {
					
			
				servidor= new ServerSocket(puerto);
				Socket cliente=null;
				System.out.println("Esperando CLiente...");
				
				cliente = servidor.accept();
				
				//ENTRADA DE DATOS CLIENTE
				InputStream entrada = null;
				entrada=cliente.getInputStream();
				DataInputStream flujoEntrada = new DataInputStream(entrada);
				
				//EL CLIENTE ME ENVÍA UN MENSAJE 
				n= flujoEntrada.readUTF();
				if(!n.equalsIgnoreCase("*")) {
					
				
				System.out.println("Palabra recibida del cliente: "+n);
				caracteres=util.contarcaracteres(n);
				System.out.println(caracteres);
				//CREAR FLUJO DE ENTRADA PARA EL CLIENTE
				
				OutputStream salida= null;
				salida= cliente.getOutputStream();
				DataOutputStream flujosalida = new DataOutputStream(salida);
				
				//ENVIAR MESAJE A CLIENTE
				
				flujosalida.writeUTF("Nº de caracteres: "+caracteres);
				
				
				
				//CERRAR STREAMS Y SOCKETS
				
				entrada.close();
				flujoEntrada.close();
				salida.close();
				flujosalida.close();
				cliente.close();
				servidor.close();
				
				}else {
					System.out.println("Termina ejecucion");
				}
				}while(!n.equalsIgnoreCase("*"));
			
			}catch(IIOException io) {
				System.out.println("Saliendo..");
			}
	}

}
