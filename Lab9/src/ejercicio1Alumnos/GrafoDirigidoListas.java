package ejercicio1Alumnos;


public class GrafoDirigidoListas<T> {
	final int CAPACIDAD_MAX = 10;//n� de ndos maximo del grafo
	int numNodos;//
	Nodo<T>[] nodos;

	public GrafoDirigidoListas() {
		this.numNodos = 0;
		this.nodos = (Nodo<T>[]) new Nodo[CAPACIDAD_MAX];
	}

	public Nodo<T>[] getNodos() {
		Nodo<T>[] nodosValidos = (Nodo<T>[])new Nodo[numNodos];
		for(int i=0; i<numNodos; i++) nodosValidos[i]=nodos[i];
		return nodosValidos;
	}

	/**
	 * A�ade un nodo al grafo con el valor pasado como par�metro
	 * Pre: No existe en el grafo un nodo con el mismo valor
	 * Pre: Hay sitio suficiente en el grafo para meter el nuevo nodo
	 */
	public void anadirNodo(T info) {
		Nodo<T> n=new Nodo<T>(info);
		nodos[numNodos]=n;		
		this.numNodos++;
	}

	/**
	 * Devuelve la posici�n que ocupa en el array de nodos el nodo cuyo valor es el pasado como par�metro
	 * Devuelve -1 si no existe ning�n nodo con dicho valor
	 */
	private int obtenerIndice(T info) {
		for(int i=0;i<numNodos; i++) {
			if(nodos[i].info.equals(info)) return i;
		}
		return -1; 
	}

	/**
	 * Elimina el nodo del grafo con el mismo valor que el pasado como par�metro, si es que existe
	 * Esto implica que tambi�n debe eliminar las aristas en las que intervenga dicho nodo
	 */
	public void eliminarNodo(T info) {
		
		boolean encontrado=false;
		
		if(obtenerIndice(info) > 0) {
			
			for(int i=0; i < nodos.length || encontrado;i++) {
				
				if(nodos[i].info.equals(info)) {
					
					for(int j=i; j < nodos.length; j++) {
						nodos[j] = null;
						nodos[j] = nodos[j+1];
					}
					numNodos--;
					encontrado = true;	
				}				
			}
		}
	}

	/**
	 * A�ade una arista entre los nodos con valor infoOrigen e infoDestino. 
	 * Si alguno de los dos no est� en el grafo, lo crea y a�ade la arista.
	 * Pre: no existe arista entre dichos nodos
	 */
	public void anadirArista(T infoOrigen, T infoDestino) {

		
		Nodo<T> origen = new Nodo<T>(infoOrigen);
		Nodo<T> destino= new Nodo<T>(infoDestino);
		
		if(obtenerIndice(infoOrigen) == -1) {
			anadirNodo(infoOrigen);
			numNodos++;
		}
			
		
		if(obtenerIndice(infoDestino) == -1) {
			anadirNodo(infoDestino);
			//numNodos++;
		}
		
		origen.adyacencias.add(destino);
	}

	/**
	 * Elimina la arista entre los nodos con valor infoOrigen e infoDestino, si es que existe. 
	 * Pre: ambos nodos est�n en el grafo
	 */
	public void eliminarArista(T infoOrigen, T infoDestino) {
		Nodo<T> origen = new Nodo<T>(infoOrigen);
		Nodo<T> destino = new Nodo<T>(infoDestino);
		
		origen.adyacencias.remove(destino);
	}

	/**
	 * Devuelve el n� de nodos del grafo
	 */
	public int size() {
		return numNodos;
	}


	/**
	 * Devuelve el n� de aristas que llegan al nodo (-1 si no existe un nodo con dicho valor)
	 */
	public int inDegree(T info) {
		int cont=0;
		Nodo<T> n =new Nodo<T>(info);
		boolean encontrado=false;
		
		for(int i=0; i< nodos.length; i++) {
			for(int j=1; j < nodos[i].adyacencias.size() || encontrado ; j++) {
				if(nodos[i].adyacencias.get(j).info.equals(info)) {
					cont++;
					encontrado=true;
				}
			}
		}
		return cont;
	}

	/**
	 * Devuelve el n� de aristas que salen del nodo (-1 si no existe un nodo con dicho valor)
	 */
	public int outDegree(T info) {
		Nodo<T> nodo= new Nodo<T>(info);
		return nodo.adyacencias.size();			
	}

	/**
	 * Imprime el n� de nodos, la lista de nodos y la lista de aristas del grafo
	 */
	public void imprimirGrafo() {
		
		System.out.println("N� nodos:" +  this.size());
		System.out.print("Nodos: ");
		for(int i=0; i<numNodos; i++) {
			System.out.print(nodos[i].info.toString()+" ");			
		}
		System.out.println("\nAristas");
		for(int i=0; i<numNodos; i++) {
			for(int j=0; j<nodos[i].adyacencias.size(); j++) {
				System.out.print("("+nodos[i].info.toString()+","+nodos[i].adyacencias.get(j).info.toString()+")");
			}
		}
	
	}
		
	
}
