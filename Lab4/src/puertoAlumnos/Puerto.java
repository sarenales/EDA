package puertoAlumnos;

import java.util.Queue;
import java.util.Stack;


public class Puerto {
	//private XXXXX parcelas; //TO DO: escoger la estructura adecuada para representar las parcelas y descomentar
	private static final int NUMPARCELAS = 10;
	private Stack<String>[] Parcelas;
	boolean encontrado=false;

	

	public Puerto() {
		Parcelas=new Stack[NUMPARCELAS];
		for(int i=0; i<NUMPARCELAS;i++) {
			Parcelas[i]=new Stack<String>();
		}
		
	}
	
	//TO DO: simularMovimientos: simula los movimientos que hace la grúa para desplazar los contenedores,
	// actualizando el contenido de las parcelas. Escribe por pantalla cada movimiento efectuado.
	public void simularMovimientos(Queue<Movimiento> movimientos) {
		
		while(!movimientos.isEmpty()) {
			
			Movimiento mov = movimientos.remove();
			
			if(mov.getTipo()=='D') {
				
				if(Parcelas[mov.getParcela()].size()==4) { //caso en el que esta lleno, añadir a la cola
					movimientos.add(mov);
					System.out.println(mov.getParcela()+" esta lleno, "+ mov.getContenedor()+" se vuelve a la cola.");
					
				}else { //añadir en la pila correspondiente.
					Parcelas[mov.getParcela()].push(mov.getContenedor());
					System.out.println("Se descarga "+mov.getContenedor()+ " en la parcela "+ mov.getParcela());
				}
				
			}else { //C
				encontrado = false;// resetear 
				
				if(Parcelas[mov.getParcela()].isEmpty()) { //caso en el que este vacia
					System.out.println("No se encuentra dicha parcela.");
					
				}else {
					while(!encontrado) {
						
						if(Parcelas[mov.getParcela()].peek().equals(mov.getContenedor())) { //si se encuentra, sacar
							Parcelas[mov.getParcela()].pop();
							System.out.println("Se carga "+mov.getContenedor()+ " desde la parcela "+ mov.getParcela());
							encontrado=true;
							
						}else {				//guardar en la parcela 0 por un tiempo.
							Parcelas[0].push(Parcelas[mov.getParcela()].peek());
							Parcelas[mov.getParcela()].pop();
							System.out.println("Se carga "+mov.getContenedor()+" en el contendor 0.");
						}
					}
					if(Parcelas[mov.getParcela()].isEmpty()) { //vaciar la parcela 0.
						
						while(!Parcelas[0].isEmpty()) {
							//Parcelas[mov.getParcela()].push(Parcelas[0].peek());
							Parcelas[mov.getParcela()].push(Parcelas[0].pop());
							System.out.println("Mover "+mov.getContenedor()+" de la parcela 0 a la parcela "+ mov.getParcela());
						}
						
					}
				}
			}
		}
		
		
		
	}


}
