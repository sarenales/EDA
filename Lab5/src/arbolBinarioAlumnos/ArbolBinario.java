package arbolBinarioAlumnos;

import java.util.LinkedList;



public class ArbolBinario<T extends Comparable<T>> {
	
	Nodo<T> root;

	//Métodos básicos
	
	public ArbolBinario() {
		this.root = null;
	}
	
	public ArbolBinario(T info) {
		this.root = new Nodo<T>(info);
	}


	public ArbolBinario(Nodo<T> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return (root == null);
	}
	
	//EJERCICIO 1
	//Devuelve la lista de elementos en inorden (lista vacía si no tiene elementos)	
	public LinkedList<T> elementosEnInOrden(){
		
		if(this.isEmpty()) return null;
		
		else return this.root.elementosEnInOrden();
		
	}
	
	
	//EJERCICIO 2
	//Devuelve si el elemento está en el árbol y en qué nivel (-1 si no está, cualquiera de los niveles en que esté si está repetido)	
	public ResultadoContainsYNivel containsYNivel(T elem) {
		
		if(this.isEmpty()) return new ResultadoContainsYNivel(false,-1);
		
		else return this.root.containsYNivel(elem,0);
	}	
	
	
	//EJERCICIO 3
	//Devuelve la altura del árbol (-1 si no tiene elementos)	
	public int altura() {
		
		if(this.isEmpty())return -1; 
		
		else return this.root.altura();
		
	}
	
	
	//EJERCICIO 4
	//Devuelve una lista con el camino desde la raíz hasta la hoja situada más a la izquierda (lista vacía si no tiene elementos)
	public LinkedList<T> obtenerCaminoHojaIzquierda(){

		if(!this.isEmpty()) return this.root.obtenerCaminoHojaIzquierda();
		return null;
	}
	
	

}
