public class invalidPriceException extends RuntimeException {
	public invalidPriceException(String message) {
		super(message);
	}
	public invalidPriceException() {
		super("invalid price!");
	}
}