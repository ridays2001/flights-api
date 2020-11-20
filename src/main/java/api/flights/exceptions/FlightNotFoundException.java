package api.flights.exceptions;

public class FlightNotFoundException extends Exception {
	public FlightNotFoundException() {
		super("Cannot find a flight with those parameters.");
	}
}
