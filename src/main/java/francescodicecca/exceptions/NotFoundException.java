package francescodicecca.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("Il record con id non è stato trovato!");
    }
}
