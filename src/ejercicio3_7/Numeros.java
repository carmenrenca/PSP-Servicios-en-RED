package ejercicio3_7;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

import utiles.trycatch;

public class Numeros implements Serializable {

	int numero;
	Long cuadrado;
	Long cubo;
	public  Numeros(int numero, Long cuadrado, Long cubo) {
		this.numero=numero;
		this.cuadrado=cuadrado;
		this.cubo=cubo;
	}
	
	public  Numeros() {
		
	}
	
public  Numeros(int numero) {
	this.numero=numero;
	}
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Long getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(int n) {
		
		this.cuadrado = (long) (n*n);
	}

	public Long getCubo() {
		return cubo;
	}

	public void setCubo(int n) {
		
		this.cubo =(long) (n*n*n);
	}



}
