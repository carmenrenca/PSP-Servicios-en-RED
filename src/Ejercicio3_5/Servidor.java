package Ejercicio3_5;

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
		int n = 0;
		DataOutputStream flujosalida ;
		OutputStream salida;
		try {
			servidor= new ServerSocket(Puerto);
			
			Socket cliente = null;
			do {
				
			
			System.out.println("Esperando CLiente...");
			
			cliente = servidor.accept();
		
		n++;
			
			//CREAR FLUJO DE ENTRADA PARA EL CLIENTE
			
			salida= null;
			salida= cliente.getOutputStream();
			flujosalida = new DataOutputStream(salida);
			
			//ENVIAR MESAJE A CLIENTE
			
			flujosalida.writeInt(n); 
			
			}while(n<=6);
			salida.close();
			flujosalida.close();
			//CERRAR STREAMS Y SOCKETS
			
			
			cliente.close();
			servidor.close();
		}catch(IIOException io){
			
		}
	}

}
