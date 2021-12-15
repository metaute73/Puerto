package cargo_imaginary_company;

import java.util.Deque;
import java.util.LinkedList;

public class Cola {
	
	int max = 5;
	Deque<Automovil>cola = new LinkedList<>();
	int consecutivo;
	
	public Cola(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	
	public void add(Automovil automovil) {
		if (cola.size() < max) {
			this.cola.add(automovil);	
		}	
	}

	
}
