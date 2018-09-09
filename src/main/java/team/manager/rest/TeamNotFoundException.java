package team.manager.rest;

public class TeamNotFoundException extends RuntimeException {

	public TeamNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TeamNotFoundException(String arg0) {
		super(arg0);
	}

	public TeamNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
}
