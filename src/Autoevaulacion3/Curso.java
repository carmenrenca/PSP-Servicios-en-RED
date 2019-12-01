package Autoevaulacion3;

import java.io.Serializable;

public class Curso implements Serializable {
String id;
String Descripcion;

public Curso() {
	
}

public Curso(String id, String D) {
	this.id=id;
	this.Descripcion=D;
	
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getDescripcion() {
	return Descripcion;
}

public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}



}
