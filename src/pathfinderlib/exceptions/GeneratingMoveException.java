package pathfinderlib.exceptions;

/**
 * Exception for Moves generation
 * @author ttgc
 * @version 1.0
 */
public class GeneratingMoveException extends Exception {
	private static final long serialVersionUID = 1L;

	public GeneratingMoveException() {
		// TODO Auto-generated constructor stub
	}

	public GeneratingMoveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GeneratingMoveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public GeneratingMoveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneratingMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
