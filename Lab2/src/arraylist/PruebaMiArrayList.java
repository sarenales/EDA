package arraylist;

public class PruebaMiArrayList {

	public PruebaMiArrayList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//ArrayList de enteros
		MiArrayList<Integer> lista = new MiArrayList<Integer>();
		lista.add(3);
		lista.add(43);
		lista.add(56);		
		
		System.out.println("Size: "+lista.size());
		System.out.println("La lista esta vacia¿? "+lista.isEmpty());
		System.out.println("Valor de la posicion 2 de la lista(56):"+lista.get(2));
		System.out.println("Indice del valor 56 es (2): "+lista.indexOf(56));
		System.out.println("contiene 56(true): "+lista.contains(56));
		lista.add(45);
		//lista.add(1, 37);
		
		System.out.println("eliminamos el valor de la posicion 3(45): "+lista.set(3,45));
		lista.add(3);
		System.out.println("eliminamos"+lista.remove(1));
		
	}

}
