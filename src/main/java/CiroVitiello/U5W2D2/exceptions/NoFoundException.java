package CiroVitiello.U5W2D2.exceptions;

public class NoFoundException extends RuntimeException {
    public NoFoundException(int id) {
        super("element with " + id + " not found");
    }
}