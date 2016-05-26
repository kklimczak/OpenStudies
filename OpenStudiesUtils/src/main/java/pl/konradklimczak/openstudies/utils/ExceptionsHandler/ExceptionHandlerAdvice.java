package pl.konradklimczak.openstudies.utils.ExceptionsHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.konradklimczak.openstudies.utils.ExceptionsHandler.Exceptions.ElementDoesNotExist;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = ElementDoesNotExist.class)
    public ResponseEntity handleNoElementException(ElementDoesNotExist e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionMessage.builder().name(e.getClass().getName()).message(e.getMessage()).build());
    }
}
