package api.flights.controllers;

import api.flights.models.Flight;
import api.flights.repositories.FlightRepository;
import api.flights.exceptions.FlightNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FlightController {
	@Autowired
	FlightRepository flightRepository;

	@GetMapping("/")
	public String something() {
		return "Hello World!";
	}

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@PostMapping("/add-flight")
	public Flight addFlight(@Valid @RequestBody Flight flight) {
		return flightRepository.save(flight);
	}
}
