package ejercicio1Alumnos;

import java.util.LinkedList;

public class Nodo<T> {

	T info;
	LinkedList<Nodo<T>> adyacencias;

	public Nodo(T info) {
		this.info = info;
		this.adyacencias = new LinkedList<Nodo<T>>();
	}

}
