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
	public List<Flight> getAllFlights(
			@RequestParam(required = false) String start,
			@RequestParam(required = false) String end,
			@RequestParam(required = false) String price
	) {
		if (price != null) {
			int p = Integer.parseInt(price, 10);
			return flightRepository.findUnderPrice(p);
		} else if (start != null && end != null) {
			return flightRepository.findByLocation(start, end);
		} else if (start != null) {
			return flightRepository.findByStart(start);
		} else if (end != null) {
			return flightRepository.findByEnd(end);
		}
			return flightRepository.findAll();
	}

	@PostMapping("/add-flight")
	public Flight addFlight(@Valid @RequestBody Flight flight) {
		return flightRepository.save(flight);
	}
}
