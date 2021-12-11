package errors;

public class Error extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Error() {
		super("No se pudo completar la accion");
	}

}