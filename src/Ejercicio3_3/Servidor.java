package Ejercicio3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.IIOException;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		int Puerto = 6000;
		ServerSocket servidor= null;
		
		try {
			servidor= new ServerSocket(Puerto);
			
			Socket cliente = null;
			System.out.println("Esperando CLiente...");
			
			cliente = servidor.accept();
			//FLUJO DE ENTRADA DEL CLIENTE
			
			
			//CREAR FLUJO DE ENTRADA PARA EL CLIENTE
			
			OutputStream salida= null;
			salida= cliente.getOutputStream();
			DataOutputStream flujosalida = new DataOutputStream(salida);
			
			//ENVIAR MESAJE A CLIENTE
			
			flujosalida.writeUTF("MENSAJE PRUEBA SERVIDOR");
			
			//ENTRADA DE DATOS CLIENTE
InputStream entrada = null;
			
			entrada=cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);
			
	//EL CLIENTE ME ENCIA UN MENSAJE 
			
			System.out.println("Mensaje del cliente: \n\t "+flujoEntrada.readUTF());
			
			
			//CERRAR STREAMS Y SOCKETS
			
			entrada.close();
			flujoEntrada.close();
			salida.close();
			flujosalida.close();
			cliente.close();
			servidor.close();
		}catch(IIOException io){
			
		}
	}

}
