package ejer2Alumnos;

public class PruebaListaJugadores {

	public PruebaListaJugadores() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//modificar para efectuar las pruebas que consider�is oportunas
		ListaDeJugadores p = new ListaDeJugadores();
		p.anadirJugador(new Jugador("Elena"));
		p.anadirJugador(new Jugador("Jon"));
		p.anadirJugador(new Jugador("Eva"));
		p.anadirJugador(new Jugador("Asier"));
		p.anadirJugador(new Jugador("Unai"));
		System.out.println("Estado al comienzo de la partida: ");
		p.print();
		p.jugar();
		System.out.println("Estado al final de la partida: ");
		p.print();

	}

}
