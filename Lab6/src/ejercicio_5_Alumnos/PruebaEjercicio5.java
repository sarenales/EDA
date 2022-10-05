package ejercicio_5_Alumnos;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class PruebaEjercicio5 {	
	
	//CÓDIGO PARA LA CARGA DE LOS EJEMPLOS DE PRUEBA, NO MODIFICAR
	
	public static ABB<Integer> cargar(String nomFich) throws Exception {
		ABB<Integer> result = new ABB<Integer>();
		Scanner source = new Scanner(new File(nomFich));
		String token = source.next();
		if (token.equals("*"))
			result.root = null;
		else if (token.equals("["))
			result.root = cargar(source);
		else
			throw new Exception(String.format("Unexpected token when reading " + "binary tree: %s", token));
		return result;
	}

	public static NodoABB<Integer> cargar(Scanner source) throws Exception{
		NodoABB<Integer> result = new NodoABB<Integer>(source.nextInt());
		String token = source.next();
		if (token.equals("]")) {
			result.left = null;
			result.right = null;
		} else {
			if (token.equals("["))
				result.left = cargar(source);
			else if (token.equals("*"))
				result.left = null;
			else
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
			token = source.next();
			if (token.equals("["))
				result.right = cargar(source);
			else if (token.equals("*"))
				result.right = null;
			else
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
			token = source.next();
			if (!token.equals("]"))
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
		}
		return result;
	}
	
	//FIN DEL CÓDIGO PARA LA CARGA DE LOS EJEMPLOS DE PRUEBA

	public static void main(String[] args) throws Exception {
		
		ABB<Integer> ab = new ABB<Integer>();
		
		for(int i=0; i<=5; i++) {
			
			System.out.println("\n-------------\n ÁRBOL "+i+"\n-------------");
			ab = cargar("src/filesABB/arbolABB"+i+".txt");			

			System.out.println("\nÁrbol original:");
			ab.imprimirArbol();
			
			int elementoAEliminar = 7;			
			
			System.out.println("\nIntentamos eliminar el "+elementoAEliminar);
			boolean remove = ab.remove(elementoAEliminar);
			System.out.println("\n¿Se ha eliminado?: "+remove);
			System.out.println("\nÁrbol tras eliminar el "+elementoAEliminar+":");
			ab.imprimirArbol();
			
			elementoAEliminar = 8;
			
			System.out.println("\nEn el árbol resultante intentamos eliminar el "+elementoAEliminar);
			remove = ab.remove(elementoAEliminar);
			System.out.println("\n¿Se ha eliminado?: "+remove);
			System.out.println("\nÁrbol tras eliminar el "+elementoAEliminar+":");
			ab.imprimirArbol();				
		}	
	}
}
