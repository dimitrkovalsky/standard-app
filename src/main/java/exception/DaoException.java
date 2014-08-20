package exception;

/**
 * Created by Dmytro_Kovalskyi on 23.07.2014.
 */
public class DaoException extends Exception
{
    public DaoException(String message) {
        super(message);
    }

    public DaoException() {
        super();
    }

    public DaoException(Exception cause) {
        super(cause);
    }

    public DaoException(String message, Exception cause) {
        super(cause);
    }
}