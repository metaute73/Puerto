package cargo_imaginary_company;
import java.util.*;

import errors.ErrorCapacidadMaxima;
import errors.ErrorSerial;
import errors.ErrorSerialNoEncontrado;

public class Puerto {
	
	static Vector<Cola>automoviles = new Vector<>();
	static Vector<Pila>contenedores = new Vector<>();
	static int maxContenedores = 0;
	static int maxAutomoviles = 0;
	static LinkedList<Contenedor>auxiliar = new LinkedList<>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//instancia el puerto con las colas de autos necesarias
		for (int i = 1; i<= 98; i++) {
			try {
				addingAutomovil(new Automovil(i));
			} catch (ErrorCapacidadMaxima e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*for (Cola a : automoviles) {
			for (Automovil k : a.cola)
				print(k.serialCode + " " + k.queue.consecutivo);
		}*/
		
		//instancia el puerto con las pilas de contenedores necesarias
		for (int i = 1; i<= 498; i++) {
			try {
				addingContenedor(new Contenedor(i));
			} catch (ErrorCapacidadMaxima e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*for (Pila a : contenedores) {
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
					+ "de automoviles\n5. para conocer el serial de pila o cola donde esta ubicado algun "
					+ "contenedor o vehiculo \n6. para salir del menu"
					+ "principal");
			
			String str = input.next();
			switch(str) {
				
			case "1":
				while(true) {
					print("Que se desea recibir?\npresione: \nC. Contenedor\nV. Vehiculo\ncualquier otra "
							+ "tecla para volver");
					String ans = input.next().toUpperCase();
					switch(ans) {
					case "C":
						print("ingrese el serial del contenedor a ser recibido: ");
						int serialC = input.nextInt();
						Contenedor ke = new Contenedor(serialC);
						try {
							checkExistance(ke, serialC);
						} catch (ErrorSerial e2) {
							// TODO Auto-generated catch block
							System.out.println(e2.getMessage());
							continue;
						}
						try {
							print("se recibio el contenedor " + serialC + " exitosamente, y se ha ubicado "
									+ "en la pila " + addingContenedor(ke));
						} catch (ErrorCapacidadMaxima e1) {
							// TODO Auto-generated catch block
							System.out.println(e1.getMessage());
						}
						continue;
					case "V":
						print("ingrese el serial del vehiculo a ser recibido: ");
						int serialV = input.nextInt();
						Automovil ak = new Automovil(serialV);
						try {
							checkExistance(ak, serialV);
						} catch (ErrorSerial e1) {
							// TODO Auto-generated catch block
							System.out.println(e1.getMessage());
							continue;
						}
						try {
							print("se recibio el vehiculo " + serialV + " exitosamente, y se ha ubicado "
									+ "en la cola " + addingAutomovil(ak));
						} catch (ErrorCapacidadMaxima e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
							continue;
						}
						continue;
					default:
						break;
					}
					break;
				}
				continue;
			case "2":
				while(true) {
				print("Que desea entregar?\npresione: \nC. Contenedor\nV. Vehiculo\ncualquier otra "
						+ "tecla para volver");
				String answer = input.next().toUpperCase();
				
				switch (answer) {
					case "C":
						print("ingrese el serial del contenedor");
						int serialCodeC = input.nextInt();
					int p;
					try {
						p = removeContenedor(serialCodeC);
						if (p > 0) {
							print("se entrego exitosamente el contenedor " + serialCodeC + " el cual "
									+ "se encontraba en la pila " + p);
						}
						System.out.println();
						} catch (ErrorSerialNoEncontrado e1) {
							// TODO Auto-generated catch block
							System.out.println(e1.getMessage());
							continue;
						}
						
						continue;
					case "V":
						print("ingrese el serial del vehiculo: ");
						int serialCode = input.nextInt();
						int s;
						try {
							s = removeAutomovil(serialCode);
							if (s > 0) {
								print("se entrego exitosamente el vehiculo " + serialCode + " el cual "
										+ "se encontraba en la cola " + s);
							}
							System.out.println();
						} catch (ErrorSerialNoEncontrado e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
							continue;
						}
						
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
				/*for (Pila a : contenedores) {
					for (Contenedor k : a.stack)
						print(k.serialCode + " " + k.stack.consecutivo);
				}*/
				for (Cola a : automoviles) {
					for (Automovil k : a.cola)
						print(k.serialCode + " " + k.queue.consecutivo);
				}
				continue;
			case "6":
				break;
			}
			break;
		}
		/*for (Cola a : automoviles) {
			for (Automovil k : a.cola)
				print(k.serialCode + " " + k.queue.consecutivo);
		}*/
		print("Gracias");
		input.close();
	}
	
	
	static void print(String str) {
		System.out.println(str);
	}
	//esta funcion agrega un vehiculo
	static int addingAutomovil(Automovil auto) throws ErrorCapacidadMaxima {
		
		if (maxAutomoviles < 100) {
			for(Cola c : automoviles) {
				if (c.cola.size() != 10) {
					auto.queue = c;
					c.cola.add(auto);
					maxAutomoviles++;
					return c.consecutivo;
				}
			}
			automoviles.add(new Cola(automoviles.size() + 1));
			auto.queue = automoviles.lastElement();
			automoviles.lastElement().add(auto);
			maxAutomoviles++;
			return automoviles.lastElement().consecutivo;
		}
		else {
			throw new ErrorCapacidadMaxima();
		}
		

	}
	//esta funcion agrega un contenedor
	static int addingContenedor(Contenedor contenedor) throws ErrorCapacidadMaxima {
		if (maxContenedores < 500) {
			for(Pila p : contenedores) {
				if (p.stack.size() != 5) {
					contenedor.stack = p;
					p.stack.push(contenedor);
					maxContenedores++;
					return p.consecutivo;
				}
			}
			contenedores.add(new Pila(contenedores.size() + 1));
			contenedor.stack = contenedores.lastElement();
			contenedores.lastElement().push(contenedor);
			maxContenedores++;
			return contenedores.lastElement().consecutivo;
		}else {
			throw new ErrorCapacidadMaxima();
		}
		
	}
	static int removeContenedor(int serial) throws ErrorSerialNoEncontrado {
		int end = 0;
		Iterator<Pila> pilas = contenedores.listIterator();
		while(pilas.hasNext()) {
			Pila pila = pilas.next();
			for (Contenedor c : pila.stack) {
				//System.out.println(c.serialCode);
				if (c.serialCode == serial) {
					if (c != pila.stack.getFirst()) {
						int first = pila.stack.peek().serialCode;
						print("se han tenido que mover los siguientes contenedores:");
						while(first != c.serialCode) {
							Contenedor contenedor = pila.stack.pollFirst();
							int change = finding(contenedor);
							if (change != 0) 
								System.out.println(contenedor.serialCode + " hacia la pila " + change);
							first = pila.stack.peek().serialCode;
						}
						
						System.out.println();
						
					}
					end = pila.consecutivo;
					pila.stack.pollFirst();
					while(!auxiliar.isEmpty()) {
						pila.push(auxiliar.pop());
					}
					break;
					
				}
			}
		}
		if (end == 0) {
			throw new ErrorSerialNoEncontrado();
		}
		return end;
	}
	static int removeAutomovil(int serial) throws ErrorSerialNoEncontrado {
		int end = 0;
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
							first = cola.cola.getFirst().serialCode;
							
						}
						System.out.println();
					}
					end = cola.consecutivo;
					cola.cola.poll();
					break;
				}
			}
		}
		if (end == 0) {
			throw new ErrorSerialNoEncontrado();
		}
		return end;
	}
	static int finding(Contenedor c) {
		int s = 0;
		boolean status = false;
		for (Pila p : contenedores) {
			if (p.stack.size() < 5 && c.stack != p) {
				p.stack.push(c);
				c.stack = p;
				s = p.consecutivo;
				status = true;
				break;
			}
		}
		if (!status) {
			print("debido a espacio el contenedor " + c.serialCode + " se ha tenido que ubicar "
					+ "en la pila auxiliar para posteriormente ser puesto de nuevo "
					+ "en su pila original");
			auxiliar.push(c);
		}
		return s;
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
			print("debido a espacio el vehiculo " + a.serialCode + " se ha tenido que estacionar "
					+ "en la cola auxiliar para posteriormente ser ubicado de nuevo "
					+ "en su cola original");
			a.queue.add(a);
		}
		
		return s;
	}
	
	static <T> void checkExistance(T x, int k) throws ErrorSerial {
		Boolean status = true;
		if (x instanceof Contenedor) {
			for (Pila p : contenedores) {
				for (Contenedor c : p.stack) {
					if (c.serialCode == k) {
						status = false;
						break;
					}
				}
				
			}
		}else {
			for (Cola c : automoviles) {
				for (Automovil a : c.cola) {
					if (a.serialCode == k) {
						status = false;
						break;
					}
				}
			}
		}
		if (!status) {
			throw new ErrorSerial();
		}
	}
	
}
