package cargo_imaginary_company;
import java.util.*;

public class Puerto {
	
	static Vector<Cola>automoviles = new Vector<>();
	static Vector<Pila>contenedores = new Vector<>();
	static int maxContenedores = 0;
	static int maxAutomoviles = 0;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//instancia el puerto con las colas de autos necesarias
		for (int i = 1; i<= 98; i++) {
			addingAutomovil(new Automovil(i));
		}
		/*
		for (Cola a : automoviles) {
			for (Automovil k : a.cola)
				print(k.serialCode + " " + k.queue.consecutivo);
		}*/
		
		//instancia el puerto con las pilas de contenedores necesarias
		for (int i = 1; i<= 498; i++) {
			addingContenedor(new Contenedor(i));
		}
		/*
		for (Pila a : contenedores) {
			for (Contenedor k : a.stack)
				print(k.serialCode + " " + k.stack.consecutivo);
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
				while(true) {
				print("Que desea entregar?\npresione: \nC. Contenedor\nV. Vehiculo\ncualquier otra "
						+ "tecla para volver");
				String answer = input.next().toUpperCase();
				
				switch (answer) {
					case "C":
						continue;
					case "V":
						print("ingrese el serial del vehiculo: ");
						int serialCode = input.nextInt();
						removeAutomovil(serialCode);
						continue;
					default:
						break;
					}
					break;
				}
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
		for (Cola a : automoviles) {
			for (Automovil k : a.cola)
				print(k.serialCode + " " + k.queue.consecutivo);
		}
		print("Gracias");
		input.close();
	}
	
	
	static void print(String str) {
		System.out.println(str);
	}
	//esta funcion agrega un vehiculo
	static void addingAutomovil(Automovil auto) {
		if (maxAutomoviles < 100) {
			for(Cola c : automoviles) {
				if (c.cola.size() != 10) {
					auto.queue = c;
					c.cola.add(auto);
					maxAutomoviles++;
					return;
				}
			}
			automoviles.add(new Cola(automoviles.size() + 1));
			auto.queue = automoviles.lastElement();
			automoviles.lastElement().add(auto);
			maxAutomoviles++;
			return;
		}

	}
	//esta funcion agrega un contenedor
	static void addingContenedor(Contenedor contenedor) {
		if (maxContenedores < 500) {
			for(Pila p : contenedores) {
				if (p.stack.size() != 5) {
					contenedor.stack = p;
					p.stack.push(contenedor);
					maxContenedores++;
					return;
				}
			}
			contenedores.add(new Pila(contenedores.size() + 1));
			contenedor.stack = contenedores.lastElement();
			contenedores.lastElement().push(contenedor);
			maxContenedores++;
			return;
		}
	}
	
	static void removeAutomovil(int serial) {
		
		Iterator<Cola>colas = automoviles.listIterator();
		while (colas.hasNext()) {
			Cola cola = colas.next();
			for (Automovil a : cola.cola) {
				if (a.serialCode == serial) {
					if (a != cola.cola.getFirst()) {
						int first = cola.cola.getFirst().serialCode;
						System.out.println("se han tenido que mover los vehiculos:");
						while(first != a.serialCode) {
							Automovil auto = cola.cola.poll();
							int change = finding(auto);
							if (change != 0)
								System.out.println(auto.serialCode + " hacia la cola " + change);
							first++;
							
						}
						System.out.println();
					}
					cola.cola.poll();
					break;
				}
			}
		}
	}
	
	static int finding(Automovil a) {
		int s = 0;
		boolean status = false;
		for (Cola c: automoviles) {
			if (c.cola.size() < 10 && a.queue != c) {
				c.cola.add(a);
				a.queue = c;
				s =  c.consecutivo;
				status = true;
				break;
			}
		}
		if (!status) {
			print("debido a espacio el vehiculo " + a.serialCode + " se ha tenido que ubicar "
					+ "en su cola original");
			a.queue.add(a);
		}
		
		return s;
	}
	
}
