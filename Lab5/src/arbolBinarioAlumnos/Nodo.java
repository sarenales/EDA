package arbolBinarioAlumnos;

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

	// EJERCICIO 1
	public LinkedList<T> elementosEnInOrden() {
		
		LinkedList<T> lista = new LinkedList<T>();
		
		if(this.hasLeft()) {
			lista.addAll(this.left.elementosEnInOrden());
		}
		//System.out.println(this.info);
		lista.addLast(info);			
		if(this.hasRight()) {
			lista.addAll(this.right.elementosEnInOrden());
		}
		
		
		return lista;
	}

	// EJERCICIO 2
	public ResultadoContainsYNivel containsYNivel(T elem, int nivel) {
		
		int cont=nivel;
		
		if(this.info.equals(elem))return new ResultadoContainsYNivel(true, cont);
		
		else {
			
			cont++;
			
			if(this.hasLeft()) {
				ResultadoContainsYNivel resultadoIzq = this.left.containsYNivel(elem, cont);
					if(resultadoIzq.contains==true){
						return containsYNivel(elem,cont);
					}
			
			}else if(this.hasRight()) {
				ResultadoContainsYNivel resultadoDer = this.right.containsYNivel(elem, cont);
				
					if(resultadoDer.contains==true) {
						return resultadoDer;
					}			
			}
		}
		
			
		
		return new ResultadoContainsYNivel(false,-1);
	}

	// EJERCICIO 3
	public int altura() {
		int altura=0;
		if(this.isLeaf()) return 0;
		if(this.hasRight()) altura=this.right.altura();
		if(this.hasLeft()) if(this.left.altura()>altura) altura=this.left.altura();
		altura++;
		return altura;
	}

	// EJERCICIO 4
	public LinkedList<T> obtenerCaminoHojaIzquierda() {
		LinkedList<T> lista = new LinkedList<T>();
		lista.addLast(this.info);
		if(this.hasLeft()) lista.addAll(this.left.obtenerCaminoHojaIzquierda());
		else if(this.hasRight()) lista.addAll(this.right.obtenerCaminoHojaIzquierda());
		return lista;
	} 
}