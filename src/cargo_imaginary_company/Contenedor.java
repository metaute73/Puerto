package cargo_imaginary_company;

public class Contenedor {
	
	int serialCode;
	Pila stack;
	public Contenedor(int serialCode) {
		this.serialCode = serialCode;
	}
	public Contenedor(int serialCode, Pila stack) {
		this.serialCode = serialCode;
		this.stack = stack;
	}
}
