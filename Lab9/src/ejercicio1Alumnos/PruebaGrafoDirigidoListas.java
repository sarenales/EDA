package ejercicio1Alumnos;


public class PruebaGrafoDirigidoListas {


	public static void main(String[] args) {
		
		GrafoDirigidoListas<String> grafo = new GrafoDirigidoListas<String>();		
			
		grafo.anadirNodo("A");
		grafo.anadirNodo("B");
		grafo.anadirNodo("C");
		grafo.anadirNodo("D");
		grafo.anadirNodo("E");
		
		grafo.anadirArista("A", "B");
		grafo.anadirArista("A", "C");
		grafo.anadirArista("A", "E");
		grafo.anadirArista("B", "C");
		grafo.anadirArista("B", "D");
		grafo.anadirArista("D", "E");
		
		System.out.println("Grafo inicial:");
		grafo.imprimirGrafo();
		
		grafo.anadirArista("D", "F");
		System.out.println("\nGrafo tras añadir arista (D,F):");
		grafo.imprimirGrafo();
		
		System.out.println("\nInDegree y OutDegree de cada nodo: ");
		for(Nodo<String> nodo:grafo.getNodos()) {
			System.out.println("Nodo "+nodo.info.toString()+":");
			System.out.println("-inDegree: "+grafo.inDegree(nodo.info));
			System.out.println("-outDegree: "+grafo.outDegree(nodo.info));
		}
		
		
		grafo.eliminarNodo("D");
		System.out.println("\nGrafo tras eliminar nodo D:");
		grafo.imprimirGrafo();
		
		grafo.eliminarArista("C","A");
		System.out.println("\nGrafo tras eliminar arista (C,A) (no existe):");
		grafo.imprimirGrafo();
		
		grafo.eliminarArista("A","C");
		System.out.println("\nGrafo tras eliminar arista (A,C):");
		grafo.imprimirGrafo();
		
		

	}

}
