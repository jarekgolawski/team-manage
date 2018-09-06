package team.manager.rest;

public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PlayerNotFoundException(String arg0) {
		super(arg0);
	}

	public PlayerNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
}
