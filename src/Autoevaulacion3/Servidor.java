package Autoevaulacion3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream bs=new ByteArrayOutputStream();
		ObjectOutputStream outObjeto= new ObjectOutputStream(bs);
		Curso c2 = new Curso("2ºCurso","Secundaria");
		Curso c1 = new Curso("1ºCurso","Secundaria");
		Curso c3 = new Curso("3ºCurso","Secundaria");
	Alumno a1= new Alumno("alumno1","Carmen",c1,8);
	
	Alumno a2= new Alumno("alumno2","Laura",c3,5);
	Alumno a3= new Alumno("alumno3","Manuel",c2,7);
	Alumno a4= new Alumno("alumno4","Natalia",c2,3);
	Alumno a5= new Alumno("alumno5","Maria",c3,9);
	Alumno[] intArray = new Alumno[]{ a1,a2,a3,a4,a5 }; 
	
	int numeroPuerto= 6000;
	DatagramSocket servidor = new DatagramSocket(numeroPuerto);
	
	InetAddress destino=InetAddress.getLocalHost();
	String recibidoid="";
while(!recibidoid.trim().equals("*")) {
	

	System.out.println("Esperando al cliente...");
	byte[] bufer = new byte[1024];
	DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
	servidor.receive(recibo);
	 recibidoid = new String (recibo.getData()).trim();
	
	System.out.println("ID RECIBIDO POR EL CLIENTE: "+recibidoid);
	
	System.out.println("   ");
	int aux=0;
	for(int i=0; i<intArray.length; i++) {
	
		if(intArray[i].getIdalumno().trim().equals(recibidoid)) {
			aux++;
			System.out.println("entra");
			System.out.println(intArray[i].getIdalumno());
			outObjeto.writeObject(intArray[i]);
			outObjeto.close();
			
			byte[] mensaje=bs.toByteArray();
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,6000);
			servidor.send(envio);
			
		}else if(i==intArray.length && aux<1) {
			Alumno Alumnonull= new Alumno("NoExiste","NoExiste",null,0);
			outObjeto.writeObject(Alumnonull);
			outObjeto.close();
			
			byte[] mensaje=bs.toByteArray();
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,6000);
			servidor.send(envio);
		}
		
		
	}
}
	System.out.println("Finalizado");
	
	
	servidor.close();
	
	
	
	}

}
