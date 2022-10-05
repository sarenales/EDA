package ejercicio_2_3_4_Alumnos;

import java.util.LinkedList;

public class Nodo<T> {

	T info;
	Nodo<T> left;
	Nodo<T> right;

	// Métodos básicos

	public Nodo(T info) {
		this.info = info;
	}

	// Devuelve si el nodo es hoja
	public boolean isLeaf() {
		return (left == null && right == null);
	}

	// Devuelve si el nodo tiene subárbol izquierdo
	public boolean hasLeft() {
		return (left != null);
	}

	// Devuelve si el nodo tiene subárbol derecho
	public boolean hasRight() {
		return (right != null);
	}
	
	public void imprimirArbol() {
		if(this.isLeaf()) System.out.print("[ "+this.info+" ] ");
		else {
			System.out.print("[ "+info+" ");
			if(this.hasLeft()) this.left.imprimirArbol();
			else System.out.print("* ");
			if(this.hasRight()) this.right.imprimirArbol();
			else System.out.print("* ");
			System.out.print("] ");
		}		
	}

	
	//EJERCICIO 2: podar	
	public void podar() {
		
		
		if(this.hasLeft() && !this.hasRight())this.left=null;
		if(this.hasRight() && !this.hasLeft() )this.right=null;
			
		if(this.hasLeft() && this.hasRight()){
			
			this.right.podar();
			
			this.left.podar();
		}
	}
	
	//EJERCICIO 3: nuevoArbolSinHojas
	public Nodo<T> nuevoArbolSinHojas(){
		
		if(this.isLeaf()) return null;
		else {
			if(this.hasLeft()) this.left = this.left.nuevoArbolSinHojas();
			if(this.hasRight()) this.right = this.right.nuevoArbolSinHojas();
			return this;
		}	
		
	}
	
	
	//EJERCICIO 4: caminoMasLargoHastaHoja
	public LinkedList<T> caminoMasLargoHastaHoja(){
		
		LinkedList<T> LI = new LinkedList<T>();
		LinkedList<T> LD = new LinkedList<T>();
		
		
		LI.add(this.info);
		LD.add(this.info);
		
		if(this.hasLeft()) LI.addAll(this.left.caminoMasLargoHastaHoja());
		if(this.hasRight()) LD.addAll(this.right.caminoMasLargoHastaHoja());		
		
		if(LI.size()==LD.size()) return LI;
		else if(LI.size()>LD.size()) return LI;
		else return LD;
		
	}
	
		
	
}