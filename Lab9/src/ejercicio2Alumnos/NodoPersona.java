package ejercicio2Alumnos;

import java.util.LinkedList;

public class NodoPersona {
	
	String nombre; //nombre de la persona
	
	LinkedList<NodoPersona> parientes; //parientes directamente relacionados

	public NodoPersona(String nombre) {
		this.nombre = nombre;
		this.parientes = new LinkedList<NodoPersona>();
	}

	public void anadirPariente(NodoPersona pariente) {
		this.parientes.add(pariente);
		pariente.parientes.add(this);
	}
}
