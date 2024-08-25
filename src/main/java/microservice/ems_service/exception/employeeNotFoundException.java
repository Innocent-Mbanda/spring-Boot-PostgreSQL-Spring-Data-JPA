package microservice.ems_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class employeeNotFoundException extends RuntimeException{

   public employeeNotFoundException(String message) {
       super(message);

   }
}
