
public class QueueUnderflowException extends Exception {
	public QueueUnderflowException() {
		super("queue is empty");
	}
	public QueueUnderflowException(String message)
	{
		super(message);
	}
}
