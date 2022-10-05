package ejercicio_1_Alumnos;

public class ArbolBinarioEnteros {
	
	NodoEnteros root;

	public ArbolBinarioEnteros() {
		
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	//EJERCICIO 1
	
	//Devuelve la suma de los nodos que están en el nivel pasado como parámetro
	public int sumarNivel(int nivelBuscado) {
		
		if(this.isEmpty()) return 0;
		
		else return root.sumarNivel(nivelBuscado,0);
	
	}

}
