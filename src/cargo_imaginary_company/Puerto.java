package cargo_imaginary_company;
import java.util.*;

public class Puerto {
	
	static Vector<Cola>automoviles = new Vector<>();
	static Vector<Pila>contenedores = new Vector<>();
	static int maxContenedores = 100;
	static int maxAutomoviles = 10;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//instancia el puerto con las colas de autos necesarias
		for (int i = 1; i<= 98; i++) {
			addingAutomovil(new Automovil(i));
		}
		
		
		for (int i = 1; i<= 498; i++) {
			addingContenedor(new Contenedor(i));
		}
	
		
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
	static void addingAutomovil(Automovil auto) {
		if (automoviles.size() != 11) {
			for(Cola c : automoviles) {
				if (c.cola.size() != 10) {
					auto.queue = c;
					c.cola.add(auto);
					return;
				}
			}
			automoviles.add(new Cola(automoviles.size() + 1));
			auto.queue = automoviles.lastElement();
			automoviles.lastElement().add(auto);
			return;
		}

	}
	static void addingContenedor(Contenedor contenedor) {
		if (contenedores.size() != 101) {
			for(Pila p : contenedores) {
				if (p.stack.size() != 5) {
					contenedor.stack = p;
					p.stack.push(contenedor);
					return;
				}
			}
			contenedores.add(new Pila(contenedores.size() + 1));
			contenedor.stack = contenedores.lastElement();
			contenedores.lastElement().push(contenedor);
			return;
		}

		
	}
	
	
}
