package ejercicio_2_3_4_Alumnos;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class PruebaEjercicio2 {
	
	
	
	//CÓDIGO PARA LA CARGA DE LOS EJEMPLOS DE PRUEBA, NO MODIFICAR
	
	public static ArbolBinario<Integer> cargar(String nomFich) throws Exception {
		ArbolBinario<Integer> result = new ArbolBinario<Integer>();
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

	public static Nodo<Integer> cargar(Scanner source) throws Exception{
		Nodo<Integer> result = new Nodo<Integer>(source.nextInt());
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
		
				
		ArbolBinario<Integer> ab;
		
		for(int i=0; i<=5; i++) {
			
			System.out.println("\n-------------\n ÁRBOL "+i+"\n-------------");
			ab = cargar("src/filesABB/arbolABB"+i+".txt");
			
			System.out.println("\nÁrbol original:");
			ab.imprimirArbol();
			
			ab.podar();
			System.out.println("\nÁrbol tras la poda de las ramas de un solo hijo:");
			ab.imprimirArbol();			
			
		}	

	}

}
