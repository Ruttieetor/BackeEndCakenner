package nl.rutger.snoek.backendcakenner.Controller;


import nl.rutger.snoek.backendcakenner.Exceptions.RecordNotFoundException;
import nl.rutger.snoek.backendcakenner.Exceptions.UsernameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@ControllerAdvice
public class ExceptionController {

        @ExceptionHandler(value = RecordNotFoundException.class)
        public ResponseEntity<Object> exception(RecordNotFoundException recordNotFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(recordNotFoundException.getMessage());
        }

        @ExceptionHandler(value = UsernameNotFoundException.class)
        public ResponseEntity<Object> exception(UsernameNotFoundException exception) {

            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler(value = UsernameExistsException.class)
        public ResponseEntity<Object> exception(UsernameExistsException exception) {

            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
}
}