package Autoevaulacion3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import utiles.trycatch;

public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		DatagramSocket cliente = new DatagramSocket();
		int Puerto=6000;
		trycatch t = new trycatch();
		InetAddress destino=InetAddress.getLocalHost();
		String idAlumno = "";
		
		
		while(!idAlumno.trim().equals("*")) {
			
			byte[]mensaje= new byte[1024];

		System.out.println("Introduza el id del alumno a visualizar: ");
		idAlumno=t.try_String();
		mensaje=idAlumno.getBytes();
		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, Puerto);
		cliente.send(envio);
//////////////////////////////
		byte[] recibidos=new byte[1024];
		System.out.println("Esperando datagrama...");
		DatagramPacket paqrecibo= new DatagramPacket (recibidos, recibidos.length );
		cliente.receive(paqrecibo);
		ByteArrayInputStream bais= new ByteArrayInputStream(recibidos);
		ObjectInputStream nEnt= new ObjectInputStream(bais);
		
		Alumno a = (Alumno) nEnt.readObject();
		System.out.println("Alumno:");
		System.out.println(a.getIdalumno());
		System.out.println(a.getNombre());
		System.out.println("\tNota: "+a.getNota());
		System.out.println("Curso:");
		System.out.println("\t"+a.getCurso().getId());
		System.out.println("\t"+a.getCurso().getDescripcion());
		
		
		 nEnt.close();
		}
		
		 cliente.close();
	}
	

}
