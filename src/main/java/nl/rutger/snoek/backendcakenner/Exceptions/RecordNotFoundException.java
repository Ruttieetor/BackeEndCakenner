package nl.rutger.snoek.backendcakenner.Exceptions;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(){
        super();
    }
    public RecordNotFoundException(String message){
        super(message);
    }
}


