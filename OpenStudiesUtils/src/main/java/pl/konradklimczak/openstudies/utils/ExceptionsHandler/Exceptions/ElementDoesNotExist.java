package pl.konradklimczak.openstudies.utils.ExceptionsHandler.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ElementDoesNotExist extends Exception {

    public ElementDoesNotExist() {
        super();
    }

    public ElementDoesNotExist(String message) {
        super(message);
    }
}
