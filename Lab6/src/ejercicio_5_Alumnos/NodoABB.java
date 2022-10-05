package ejercicio_5_Alumnos;

public class NodoABB<T extends Comparable<T>> {

	T info;
	NodoABB<T> left;
	NodoABB<T> right;

	public NodoABB(T info) {
		this.info = info;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void imprimirArbol() {
		if (this.isLeaf())
			System.out.print("[ " + this.info + " ] ");
		else {
			System.out.print("[ " + info + " ");
			if (this.hasLeft())
				this.left.imprimirArbol();
			else
				System.out.print("* ");
			if (this.hasRight())
				this.right.imprimirArbol();
			else
				System.out.print("* ");
			System.out.print("] ");
		}
	}

	//EJERCICIO 5: remove


	public boolean remove(T elem) {
		
		int comp = elem.compareTo(this.info);
		
		if(comp==0) {//Caso (a): this es el nodo a eliminar
			if(!this.hasLeft()) return this.right; //Caso (a1)
			
			else if(!this.hasRight()) return this.left; //Caso (a2)
			
			else {//Caso (a3): Tiene los dos subarboles, sustituir por el valor mínimo del subarbol derecho
				
				ResultadoRemoveMin<T> min = this.right.removeMin();
				this.right = min.elNodo;
				this.info = min.elValor;
				return this;
			}//if
			else if(comp<0){//Caso (b) El elemento a eliminar, si está, estará en el subárbol izq
				if(this.hasLeft()) this.left = this.left.remove(elem);
				return this;
			}else {//comp>0: Caso (c) El elemento a eliminar, si está, estará en el subárbol dcho
				if (this.hasRight()) this.right = this.right.remove(elem);
				return this;
			}
		}
	
