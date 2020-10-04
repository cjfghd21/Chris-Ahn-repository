
public class InvalidNotationFormatException extends Exception {
	public InvalidNotationFormatException() {
		super("Not valid notation");
	}
	public InvalidNotationFormatException(String message)
	{
		super(message);
	}
}

