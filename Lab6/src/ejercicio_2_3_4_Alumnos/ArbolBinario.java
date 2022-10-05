package ejercicio_2_3_4_Alumnos;

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
	
	public void imprimirArbol() {
		if (this.isEmpty())
			System.out.println("*");
		else {
			this.root.imprimirArbol();
			System.out.println();
		}

	}
	
	
	//EJERCICIO 2:
	
	//Poda del árbol todas aquellas ramas que tienen un único hijo.
	public void podar() {
		
		if(!this.isEmpty()) this.root.podar();
		
	}
	
	
	
	//EJERCICIO 3:
	
	//Devuelve un árbol igual que el actual pero sin las hojas.
	//No modifica el árbol original
	public ArbolBinario<T> nuevoArbolSinHojas(){
		
		
		if(this.isEmpty()) 	 return new ArbolBinario<T>();
		else {
			ArbolBinario<T> nuevo = new ArbolBinario<T>();
			nuevo.root=this.root.nuevoArbolSinHojas();
			return nuevo;
		}
		
		
	}
	
	

	//EJERCICIO 4:
	
	//Devuelve una lista con el camino desde la raíz hasta la hoja más profunda.
	//En caso de empate, el camino que esté más a la izquierda.	
	public LinkedList<T> caminoMasLargoHastaHoja(){
		if(!this.isEmpty()) {
			LinkedList<T> nuevo=new LinkedList<T>();
			nuevo.addAll(this.root.caminoMasLargoHastaHoja());
		}
		return new LinkedList<T>();
	}
		

}
