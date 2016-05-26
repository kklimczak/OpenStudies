package pl.konradklimczak.openstudies.utils.ExceptionsHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.konradklimczak.openstudies.utils.ExceptionsHandler.Exceptions.ElementDoesNotExist;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(value = ElementDoesNotExist.class)
    public ResponseEntity handleNoElementException(ElementDoesNotExist e) {
        logger.error("{}: {}", e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionMessage.builder().name(e.getClass().getName()).message(e.getMessage()).build());
    }
}
