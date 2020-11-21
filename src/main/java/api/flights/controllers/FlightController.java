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
			@RequestParam(required = false) String price,
			@RequestParam(required = false) String provider
	) {
		if (price != null && start != null && end != null) {
			int p = Integer.parseInt(price, 10);
			return flightRepository.findByPriceAndLocation(p, start, end);
		} else if (price != null) {
			int p = Integer.parseInt(price, 10);
			return flightRepository.findUnderPrice(p);
		} else if (start != null && end != null) {
			return flightRepository.findByLocation(start, end);
		} else if (start != null) {
			return flightRepository.findByStart(start);
		} else if (end != null) {
			return flightRepository.findByEnd(end);
		} else if (provider != null) {
			return flightRepository.findByProvider(provider);
		}
			return flightRepository.findAll();
	}

	@GetMapping("/flights/{id}")
	public Flight getFlightById(@PathVariable(value = "id") int id) throws FlightNotFoundException {
		return flightRepository.findById(id).orElseThrow(FlightNotFoundException::new);
	}

	@PostMapping("/add-flight")
	public Flight addFlight(@Valid @RequestBody Flight flight) {
		return flightRepository.save(flight);
	}
}
