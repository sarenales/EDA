package ejercicio_5_Alumnos;


public class ABB<T extends Comparable<T>> {

	NodoABB<T> root;

	public ABB() {
		// TODO Auto-generated constructor stub
	}
	
	//M�TODOS AUXILIARES

	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void imprimirArbol() {
		if (this.isEmpty())
			System.out.println("*");
		else {
			this.root.imprimirArbol();
			System.out.println();
		}

	}
	
	//EJERCICIO 5
	
	//Elimina del �rbol el elemento pasado como par�metro, si es que est�.
	//Devuelve true si lo ha eliminado, false en caso contrario.
	public void remove(T elem) {
		 if(!this.isEmpty()) {
		 this.root = this.root.remove(elem);
		 }
		}

}
