package ejer1Alumnos;


public class Palabra {
	private Node<Character> first;
	private Node<Character> last;
	
	
	//Constructora: dado un string lo convierte en lista doblemente encadenada	
	public Palabra(String valores) {
		if (valores.length() > 0) {
			Node<Character> newNode = new Node<Character>(valores.charAt(0));
			first = newNode;
			last = newNode;
			for (int i = 1; i < valores.length(); i++) {
				newNode = new Node<Character>(valores.charAt(i));
				last.next = newNode;
				newNode.prev = last;
				last = last.next;
			}
		}
	}
	
	
	//METODOS A COMPLETAR EN EL LAB 3: replicarVocales, entrecomillar
	
	//Hace tantas copias de las vocales como indica 'veces'
	//Ejemplo: si la lista contiene 'hola', replicarVocales(2) la convertirá en 'hooolaaa'
	
	public void replicarVocales(int veces) {
		//TO DO
		
		Node<Character> actual=this.first; 
		
		
		while(actual!= null) {
			
			Node<Character> siguiente= actual.next;
			
			if(actual.equals(this.last)) { 				//Solo es un nodo
				
				if(actual.info.equals('a')||actual.info.equals('A')||actual.info.equals('o')||actual.info.equals('O')){	
					
						Node<Character> newNode = new Node<Character>(actual.info);	//añadimos detras de la lista					
						actual.next=newNode;
						this.last=actual.next;			
					
				}
				
			}else {										//Mas de un nodo.
				
				if(actual.info.equals('a')||actual.info.equals('A')||actual.info.equals('o')||actual.info.equals('O')) {
				
					for(int i=0; i<=veces;i++) {
						Node<Character> newNode = new Node<Character>(actual.info);
						actual.next=newNode;
						actual.next=siguiente;			
					}
				
				actual=actual.next;
				}
			}
			
			
		}
		
		
	}
	
	
	public void entrecomillar() {
		//TO DO
		Node<Character> actual=this.first; 
		
		char comilla= '"';
		
		while(actual!= null) {
			
			Node<Character> siguiente= actual.next;
			
			if(actual.equals(this.last)) {
						
						Node<Character> newNode = new Node<Character>(comilla);
						actual.next=newNode;
						this.last=actual.next;			
				
			}else {
						Node<Character> newNode = new Node<Character>(comilla);
						actual.next=newNode;
						actual.next=siguiente;			
					}
				
				actual=actual.next;
				}
			}
		
		
	
	
	
	//METODOS AUXILIARES PARA PRUEBAS
	
	public void imprimirAlDerecho() {
		Node<Character> current = first;
		System.out.print("[");
		while(current!=null) {
			System.out.print(current.info+" ");
			current = current.next;
		}
		System.out.println("]");
	}
	
	public void imprimirAlReves() {
		Node<Character> current = last;
		System.out.print("[");
		while(current!=null) {
			System.out.print(current.info+" ");
			current = current.prev;
		}
		System.out.println("]");
	}


}
