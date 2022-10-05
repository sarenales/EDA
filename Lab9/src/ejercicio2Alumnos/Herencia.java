package ejercicio2Alumnos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Herencia {
	
	private int numVertices;
	private ArrayList<NodoPersona> personas;

	public Herencia(int numVertices) {
		this.numVertices = numVertices;
		this.personas = new ArrayList<NodoPersona>();
	}
	
	public ArrayList<NodoPersona> getPersonas(){
		return this.personas;
	}
	
	
	
	// pre:  distMax indica la distancia máxima de las personas a las que se repartirá la herencia
	// pre: valor indica el valor de la herencia
	// post: el resultado es la cantidad que tocará a cada uno de los 
	//      beneficiarios de la herencia, que se calcula dividiendo la cantidad a 
	//      repartir a partes iguales entre las personas que se encuentran a 
	//      una distancia menor igual a distMax de la persona con nombre nomP.
	//      Devolverá -1 si la persona no existe o no tiene beneficiarios
	public int repartirHerencia(String nomP, int valor, int distMax) {

		
		NodoPersona p = buscarPorNombre(nomP);
		if(p == null) return -1;
		
		HashSet<NodoPersona> visitados = new HashSet<NodoPersona>();
		visitados.add(p);
		int contador=0;
		Queue<NodoPersonaYDistancia> cola = new LinkedList<NodoPersonaYDistancia>();
		cola.add(new NodoPersonaYDistancia(p,0));
		
		while(!cola.isEmpty()) {
			NodoPersonaYDistancia pyd = cola.remove();
			if(pyd.distancia>0 && pyd.distancia<=distMax) contador++; 
			if(pyd.distancia<distMax) {
				Iterator<NodoPersona> it= pyd.nodo.parientes.iterator();
				while(it.hasNext()) {
					NodoPersona pariente = it.next();
					if(!visitados.contains(pariente)) {
						visitados.add(pariente);
						cola.add(new NodoPersonaYDistancia(pariente,pyd.distancia+1));
					}
				}
			}
		} 
		if(contador>0) return valor/contador;
		else return -1;
	}
	

	private NodoPersona buscarPorNombre(String nomPersona) {
		for(int i=0; i<numVertices; i++) {
			if(personas.get(i).nombre.equals(nomPersona)) return personas.get(i);
		}
		return null;
	}


}
