package by.it_academy.jd2.storage.api.exceptions;

public class StorageException extends RuntimeException{

    public StorageException(Throwable cause) {
        super(cause);
    }
    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
