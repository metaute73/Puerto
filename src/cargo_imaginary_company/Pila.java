package cargo_imaginary_company;

import java.util.*;

public class Pila {
	
	int max = 10;
	Stack<Contenedor>stack = new Stack<>();
	int consecutivo;
	
	
	public void push(Contenedor contenedor) {
		if (stack.size() < max)
			this.stack.push(contenedor);
	}
	
}
