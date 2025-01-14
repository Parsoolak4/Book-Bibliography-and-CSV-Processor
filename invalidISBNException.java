public class invalidISBNException extends RuntimeException {
	public invalidISBNException(String message) {
		super(message);
	}
	public invalidISBNException() {
		super("");
	}
}
