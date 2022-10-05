package ejer3Alumnos;

public class PruebaMyLinkedList {

	public PruebaMyLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//Lista de enteros
		MyLinkedList<Integer> lista = new MyLinkedList<Integer>();
		//lista.removeLast(); //Ahora como está vacía lanza excepción
				
		//TO DO
		
		lista.addOrdered(6);
		lista.addOrdered(5);
		lista.addOrdered(9);
		lista.addOrdered(2);
		lista.addOrdered(5);

		
		lista.remove(5);
		System.out.println("El ultimo de la lista es: "+lista.getLast());
		
	}

}
