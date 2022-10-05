package impresorasAlumnos;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CentroDeCalculo {
	//private XXXXXX impresoras; //TO DO: escoger la estructura para representar las impresoras y descomentar
	private Queue<String>[] arrayDeColas;
	private boolean problema,encontrado;
	int i;
	
	public CentroDeCalculo() {
		//TO DO: creación de las impresoras
		
		arrayDeColas= (LinkedList<String>[])new LinkedList[5];
		
		for(int i=0; i<5; i++){
			arrayDeColas[i] = new LinkedList<String>();
		} 
		
		
		problema=false;
		encontrado=false;
	}
	
	
	//TO DO: completar simularEventos: simula los eventos del fichero y al finalizar imprime los nombres de los archivos que quedan en cada impresora
	public void simularEventos(String nomFich) throws IOException {
		
		Scanner sc = new Scanner(new File(nomFich));		
		String[] datos;

		while(sc.hasNextLine()) {
			datos = sc.nextLine().split("\\s+"); 	// "\\s+" --> expresion regular para indicar los espacios 
			
			//split --> almacena saltando las posiciones en blanco, en este caso.
			switch(datos[0]) {
			case "S": 
						//solicitar una impresion	
					if(problema) {
						arrayDeColas[4].add(datos[2]);
					}else {
						switch(datos[1]) {
					case "1":
						arrayDeColas[1].add(datos[2]);
						break;
					case "2":
						arrayDeColas[2].add(datos[2]);
						break;
					case "3":
						arrayDeColas[3].add(datos[2]);
						break;
					case "4":
						arrayDeColas[4].add(datos[2]);
						break;
					}
				}
					
					
				      break;
			case "I": 
		
				int i=Integer.parseInt(datos[1]);
				
					if(!arrayDeColas[i].isEmpty()) {
						System.out.println("Impresora: "+ datos[1]+" "+arrayDeColas[i].remove());
						
					}else {
						System.out.println("Vacio");
					}
				
				
				//Imprimir el primer trabajo que este 0 < 1 < 2 < 3 < 4			
				/**
				while(i<5 || encontrado) {
					if(!arrayDeColas[i].isEmpty()) {
						System.out.println("Impresora: "+ datos[i] + datos[2]);
						arrayDeColas[i].remove(datos[2]);
						encontrado=true;
					}
					i++;
				}*/
			
					
				      break;
			case "P": 
						//Indica el inicio de un problema
				System.out.println("Ha habido un problema");
				for(int j=0; j<4;j++) {
						while(!arrayDeColas[j].isEmpty()) {
							
							arrayDeColas[4].add(arrayDeColas[j].remove());
						}
					
				}
				problema=true;
				
				      break;
			case "F": 
						//Para indicar el fin de un problema
				     problema=false;
				     System.out.println("Fin del problema");
				
				     break;
			default: break;
			}
		}
		sc.close();
		//TO DO
	}


}
