package ejercicio_1_Alumnos;

public class NodoEnteros {

	int info;
	NodoEnteros left;
	NodoEnteros right;

	public NodoEnteros(int info) {
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
	
	//EJERCICIO 1: sumarNivel	
	public int sumarNivel(int NivelBuscado, int nivelActual) {
		
		int result=0;
		
		if( nivelActual==NivelBuscado) {
			return this.info;
		}else {
			if(this.hasLeft()) result+= left.sumarNivel(NivelBuscado,nivelActual+1);
			if(this.hasRight()) result+= right.sumarNivel(NivelBuscado,nivelActual+1);
			
			return result;
		}
				
	}

}
