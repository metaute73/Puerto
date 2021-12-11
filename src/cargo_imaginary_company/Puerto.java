package cargo_imaginary_company;
import java.util.*;

public class Puerto {
	
	static Vector<Cola>automoviles = new Vector<>();
	static Vector<Pila>contenedores = new Vector<>();
	int maxContenedores = 100;
	int maxAutomoviles = 10;
	
	public static void main(String[] args) {
		
		//instancia el puerto con las colas de autos necesarias
		int k = 1;
		Cola cola = new Cola(k);
		
		for (int i = 1; i <= 498; i++) {
			
			if (!cola.add(new Automovil(i,cola))) {
				automoviles.add(cola);
				k++;
				cola = new Cola(k);
				cola.add(new Automovil(i,cola));
			}
		}
		automoviles.add(cola);

		//instancia el puerto con las pilas de contonedores necesarias
		int m = 1;
		Pila pila = new Pila(m);
		for (int j = 1; j <= 98; j++) {
			
			if (!pila.push(new Contenedor(j, pila))) {
				contenedores.add(pila);
				m++;
				pila = new Pila(m);
				pila.push(new Contenedor(j, pila));
			}
		}
		contenedores.add(pila);
		/*for(Cola c : automoviles) {
			for (Automovil a : c.cola) {
				System.out.println(a.serialCode + " " + a.queue.consecutivo);
				
			}
		}
		
		for(Pila c :contenedores) {
			for (Contenedor a : c.stack) {
				System.out.println(a.serialCode + " " + a.stack.consecutivo);
				
			}
		
		}*/
	}
	
}
