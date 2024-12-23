package day1223;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 8423333175306814392L;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message);
	}

}
