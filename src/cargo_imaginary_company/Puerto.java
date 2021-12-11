package cargo_imaginary_company;
import java.util.*;

public class Puerto {
	
	static Vector<Cola>automoviles = new Vector<>();
	static Vector<Pila>contenedores = new Vector<>();
	int maxContenedores = 100;
	int maxAutomoviles = 10;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
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
		
		//menu principal
		print("Bienvenido a Cargo Imaginary Company");
		
		while (true) {
			print("Que desea hacer?\n\npresione:");
			print("1. para recibir vehiculo o contenedor\n2. para entregar vehiculo o contenedor\n"
					+ "3. para conocer el numero de contenedores y vehiculos\n"
					+ "4. para conocer los elementos de alguna pila de contenedores o alguna cola "
					+ "de automoviles\n5. para conocer serial de pila o cola\n6. para salir del menu"
					+ "principal");
			
			String str = input.next();
			switch(str) {
				
			case "1":
				print("1");
				continue;
			case "2":
				print("2");
				continue;
			case "3":
				print("3");
				continue;
			case "4":
				print("4");
				continue;
			case "5":
				print("5");
				continue;
			case "6":
				break;
			}
			break;
		}
		print("Gracias");
	}
	static void print(String str) {
		System.out.println(str);
	}
	
}
