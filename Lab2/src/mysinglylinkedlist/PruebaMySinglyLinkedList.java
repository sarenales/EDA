package mysinglylinkedlist;

public class PruebaMySinglyLinkedList {

	public PruebaMySinglyLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//Lista de enteros
		MySinglyLinkedList<Integer> lista = new MySinglyLinkedList<Integer>();
		
		System.out.println("Is empty?: "+lista.isEmpty());
		
		lista.addFirst(7);
		lista.addFirst(4);
		lista.addFirst(3);
		lista.addLast(8);
		
		
		System.out.println("Is empty now?: "+lista.isEmpty());
		System.out.println("Contains the number 6?: "+lista.contains(6));
		System.out.println("Contains the number 4?: "+lista.contains(4));
		System.out.println("Contains the number 7?: "+lista.contains(7));
		System.out.println("Contains the number 8?: "+lista.contains(8));
		
		System.out.println("Primera posicion eliminada: "+lista.removeFirst());
		lista.addOrdered(6);
		System.out.println("Contains the number 6?: "+lista.contains(6));
	
	}

}
