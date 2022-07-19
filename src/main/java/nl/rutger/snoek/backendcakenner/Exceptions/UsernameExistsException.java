package nl.rutger.snoek.backendcakenner.Exceptions;

public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException(String username){
        super("username " + username + " already exists");
    }
}
