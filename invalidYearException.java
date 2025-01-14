public class invalidYearException extends RuntimeException {
	public invalidYearException(String message) {
		super(message);
	}
	public invalidYearException() {
		super("invalid year!");
	}
}