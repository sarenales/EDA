package ejer1Alumnos;

public class PruebaPalabra {


	public static void main(String[] args) {
		//modificar para efectuar las pruebas que consider�is oportunas
		Palabra lc = new Palabra("hola");
		
		lc.imprimirAlReves();
		lc.imprimirAlDerecho();
		
		
		lc.replicarVocales(2);
		lc.imprimirAlDerecho();
		lc.imprimirAlReves();

		lc.entrecomillar();
		lc.imprimirAlDerecho();
		lc.imprimirAlReves();

	}

}
