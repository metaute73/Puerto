package cargo_imaginary_company;

import java.util.*;

public class Pila {
	
	int max = 5;
	Deque<Contenedor>stack = new LinkedList<>();
	int consecutivo;
	
	public Pila(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	
	public void push(Contenedor contenedor) {
		if (stack.size() < max) {
			this.stack.push(contenedor);
		}
	}
	
}
