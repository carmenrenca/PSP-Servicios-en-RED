package ejercicio3_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


import utiles.trycatch;

public class ejercicio1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress dir= null;
		
		System.out.println("SALIDA LOCALHOST");
		try {
			dir= InetAddress.getByName("localhost");
			pruebaMetodos(dir);
			System.out.println("SALIDA PARA URL");
			dir= InetAddress.getByName(introduceweb());
			pruebaMetodos(dir);
				System.out.println("\tDIRECCION IP PARA: "+dir.getHostName());
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			
			for(int i=0; i<direcciones.length; i++) {
				System.out.println("\t\t"+direcciones[i].toString());
			}
		}catch(UnknownHostException el){
			el.printStackTrace();
		}
	}
	
	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMetodo getByName(): "+ dir);
		InetAddress dir2;
		try {
			dir2=InetAddress.getLocalHost();
			System.out.println("\tMetodo getLocaHost(): "+dir2);
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		//USAMOS METODOS DE LA CLASE
		
		System.out.println("\tMetodo getHostName(): "+dir.getHostName());
		System.out.println("\tMetodo getHostAddress(): "+dir.getHostAddress());
		
		System.out.println("\tMetodo toString(): "+dir.toString());
		System.out.println("\tMetodo get CnocicalHostName(): "+dir.getCanonicalHostName());
		
	}
	
	public static String introduceweb() throws IOException {
		trycatch t = new trycatch();
		
		String web = t.try_String();
	
		
		
		return web;
		
	}

}
