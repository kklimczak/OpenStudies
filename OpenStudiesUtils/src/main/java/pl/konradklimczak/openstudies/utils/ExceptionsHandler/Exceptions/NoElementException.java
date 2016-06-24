package pl.konradklimczak.openstudies.utils.ExceptionsHandler.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoElementException extends Exception {

    public NoElementException() {
        super();
    }

    public NoElementException(String message) {
        super(message);
    }
}
