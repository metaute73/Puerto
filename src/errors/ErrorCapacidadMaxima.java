package errors;

public class ErrorCapacidadMaxima extends Error{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "se ha llegado a la capacidad maxima";
    public ErrorCapacidadMaxima() {
        super();
    }

    public String getMessage(){
        return super.getMessage() + "\n" + this.message;
    }

}