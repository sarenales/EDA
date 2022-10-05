package ejer2Alumnos;

import java.util.Random;

public class ListaDeJugadores {
	Nodo<Jugador> first;
	
	public ListaDeJugadores() {	}

	
	//MÉTODOS A DESARROLLAR EN EL LAB 3: anadirJugador, jugar
	

	//Añade al jugador j en la primera posición de la lista
	public void anadirJugador(Jugador j) {
		
		Nodo<Jugador> primero=this.first;	
		
		Nodo<Jugador> newNode= new Nodo<Jugador>(j);
		
		if(this.first==null) {
			
			this.first=newNode;
			
			this.first.next=this.first;
			
			this.first.prev=this.first;
			
		}else {
		
			Nodo<Jugador> ultimo=this.first.prev;
		
			newNode.next=this.first;
		
			newNode.prev=ultimo;
			
			primero.prev=newNode;
		
			this.first=newNode;
		
			ultimo.next=this.first;
		}
		
		
	}
	
	
	//Simula el desarrollo de la partida siguiendo la descripción del enunciado
	public void jugar() {
		Random rnd = new Random(System.currentTimeMillis());
		
		Nodo<Jugador> actual=this.first;
		 
		//TO DO
		while(this.first!=this.first.next) {
			//genera un numero aleatorio que luego restara
			int puntosRestar = rnd.nextInt(6)+1; 
			actual.info.setPuntos(actual.info.getPuntos()-puntosRestar);
			
			if(actual.info.getPuntos()<=0) {
				
				System.out.println(actual.info.getNombre()+" tira el dado:"+puntosRestar+".\r\n" + "Le quedan 0 puntos");
				System.out.println("El jugador ya no juega.");
				
				actual.next.prev=actual.prev;
				actual.prev.next=actual.next;
				
				if(actual==first) {
					first=actual.next;
				}
				actual=actual.next;
				
				
			}else {
				System.out.println(actual.info.getNombre()+" tira el dado:"+puntosRestar+".\r\n" + "Le quedan "+ actual.info.getPuntos()+" puntos");
				actual=actual.next;
			}
			
		}
		
		System.out.println(actual.info.getNombre()+" ha ganado la partida.");
		
	}
	
	
	//MÉTODOS AUXILIARES PARA PRUEBAS
	
	//Imprime la lista de jugadores
	public void print() {
		if (first != null) {
			Nodo<Jugador> actual = first;
			while (actual.next != first) {
				System.out.print(actual.info.toString() + " ");
				actual = actual.next;
			}
			System.out.println(actual.info.toString() + " ");
		}
	}


}
