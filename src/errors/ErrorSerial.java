package errors;

public class ErrorSerial extends Error{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String message = "este serial ya se encuentra en los registros, por favor intentarlo de nuevo";
    public ErrorSerial() {
        super();
    }

    public String getMessage(){
        return super.getMessage() + "\n" + this.message;
    }


}