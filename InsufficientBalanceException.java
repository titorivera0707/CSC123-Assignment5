
public class InsufficientBalanceException extends Exception {

	public InsufficientBalanceException(String message) {
		super(message);
        System.out.println(message);
	}

	
}