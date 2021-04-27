package kz.saparov.dental.exception;

public class AppointmentsNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AppointmentsNotFoundException(String message) {
		super(message);
	}
}
