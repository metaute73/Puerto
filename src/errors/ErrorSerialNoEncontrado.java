package errors;

public class ErrorSerialNoEncontrado extends Error{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "este serial no se encuentra en los registros, no es posible completar la entrega";
    public ErrorSerialNoEncontrado() {
        super();
    }

    public String getMessage(){
        return super.getMessage() + "\n" + this.message;
    }

}
