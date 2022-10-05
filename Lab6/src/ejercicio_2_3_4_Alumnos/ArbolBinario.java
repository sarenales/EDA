package ejercicio_2_3_4_Alumnos;

import java.util.LinkedList;



public class ArbolBinario<T extends Comparable<T>> {
	
	Nodo<T> root;

	//M�todos b�sicos
	
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
	
	//Poda del �rbol todas aquellas ramas que tienen un �nico hijo.
	public void podar() {
		
		if(!this.isEmpty()) this.root.podar();
		
	}
	
	
	
	//EJERCICIO 3:
	
	//Devuelve un �rbol igual que el actual pero sin las hojas.
	//No modifica el �rbol original
	public ArbolBinario<T> nuevoArbolSinHojas(){
		
		
		if(this.isEmpty()) 	 return new ArbolBinario<T>();
		else {
			ArbolBinario<T> nuevo = new ArbolBinario<T>();
			nuevo.root=this.root.nuevoArbolSinHojas();
			return nuevo;
		}
		
		
	}
	
	

	//EJERCICIO 4:
	
	//Devuelve una lista con el camino desde la ra�z hasta la hoja m�s profunda.
	//En caso de empate, el camino que est� m�s a la izquierda.	
	public LinkedList<T> caminoMasLargoHastaHoja(){
		if(!this.isEmpty()) {
			LinkedList<T> nuevo=new LinkedList<T>();
			nuevo.addAll(this.root.caminoMasLargoHastaHoja());
		}
		return new LinkedList<T>();
	}
		

}
