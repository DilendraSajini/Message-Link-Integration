package app.common.exceptions;

public class ClientException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClientException(String errorMessage) {
		super(errorMessage);
	}

}
