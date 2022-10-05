package ejercicio2Alumnos;

public class PruebaHerencia {
	private static Herencia h;

	public PruebaHerencia(int size) {
		//Creación del grafo del ejemplo
		h = new Herencia(size);
		NodoPersona ander = new NodoPersona("ander");
		NodoPersona juan = new NodoPersona("juan");
		NodoPersona ana = new NodoPersona("ana");
		NodoPersona kepa = new NodoPersona("kepa");
		NodoPersona sara = new NodoPersona("sara");
		NodoPersona iker = new NodoPersona("iker");
		NodoPersona pedro = new NodoPersona("pedro");
		NodoPersona jon = new NodoPersona("jon");
		NodoPersona markel = new NodoPersona("markel");
		NodoPersona amaia = new NodoPersona("amaia");
		NodoPersona gorka = new NodoPersona("gorka");
		NodoPersona luis = new NodoPersona("luis");
		NodoPersona oscar = new NodoPersona("oscar");
		NodoPersona aurora = new NodoPersona("aurora");
		NodoPersona joseba = new NodoPersona("joseba");
		NodoPersona bego = new NodoPersona("bego");
		NodoPersona pilar = new NodoPersona("pilar");
		NodoPersona santi = new NodoPersona("santi");
		NodoPersona jorge = new NodoPersona("jorge");
		NodoPersona luisa = new NodoPersona("luisa");
		NodoPersona xabi = new NodoPersona("xabi");
		
		h.getPersonas().add(ander);
		h.getPersonas().add(juan);
		h.getPersonas().add(ana);
		h.getPersonas().add(kepa);
		h.getPersonas().add(sara);
		h.getPersonas().add(iker);
		h.getPersonas().add(pedro);
		h.getPersonas().add(jon);
		h.getPersonas().add(markel);
		h.getPersonas().add(amaia);
		h.getPersonas().add(gorka);
		h.getPersonas().add(luis);
		h.getPersonas().add(oscar);
		h.getPersonas().add(aurora);
		h.getPersonas().add(joseba);
		h.getPersonas().add(bego);
		h.getPersonas().add(pilar);
		h.getPersonas().add(santi);
		h.getPersonas().add(jorge);
		h.getPersonas().add(luisa);
		h.getPersonas().add(xabi);
		
		juan.anadirPariente(ander);
		juan.anadirPariente(ana);
		ana.anadirPariente(ander);
		kepa.anadirPariente(juan);
		kepa.anadirPariente(sara);
		kepa.anadirPariente(iker);
		iker.anadirPariente(pedro);
		iker.anadirPariente(xabi);
		pedro.anadirPariente(jon);
		pedro.anadirPariente(xabi);
		pedro.anadirPariente(amaia);
		amaia.anadirPariente(markel);
		amaia.anadirPariente(xabi);
		bego.anadirPariente(iker);
		xabi.anadirPariente(jorge);
		xabi.anadirPariente(santi);
		santi.anadirPariente(pilar);
		jorge.anadirPariente(joseba);
		luisa.anadirPariente(joseba);
		joseba.anadirPariente(aurora);
		markel.anadirPariente(gorka);
		gorka.anadirPariente(luis);
		luis.anadirPariente(oscar);
	}

	public static void main(String[] args) {
		
        new PruebaHerencia(21);				
		
        System.out.println("Se reparte la herencia de pedro, valorada en 100000€, entre sus parientes a distancia máxima 2:");
        System.out.println("Cada uno de ellos recibirá "+h.repartirHerencia("pedro", 100000, 2)+"€");
        
        System.out.println("\nSe reparte la herencia de kepa, valorada en 300000€, entre sus parientes a distancia máxima 4:");
        System.out.println("Cada uno de ellos recibirá "+h.repartirHerencia("kepa", 300000, 4)+"€");
        
        System.out.println("\nSe reparte la herencia de amaia, valorada en 20000€, entre sus parientes a distancia máxima 8:");
        System.out.println("Cada uno de ellos recibirá "+h.repartirHerencia("amaia", 20000, 8)+"€");
		

	}

}
