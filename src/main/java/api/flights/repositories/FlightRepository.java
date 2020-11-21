package api.flights.repositories;

import api.flights.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	@Query(value = "SELECT * FROM flight WHERE start = :start AND end = :end", nativeQuery = true)
	List<Flight> findByLocation(String start, String end);

	@Query(value = "SELECT * FROM flight WHERE start = :start", nativeQuery = true)
	List<Flight> findByStart(String start);

	@Query(value = "SELECT * FROM flight WHERE end = :end", nativeQuery = true)
	List<Flight> findByEnd(String end);

	@Query(value = "SELECT * FROM flight WHERE price < :price", nativeQuery = true)
	List<Flight> findUnderPrice(int price);

	@Query(value = "SELECT * FROM flight WHERE price < :price and start = :start and end = :end", nativeQuery = true)
	List<Flight> findByPriceAndLocation(int price, String start, String end);

	@Query(value = "SELECT * FROM flight WHERE provider = :provider", nativeQuery = true)
	List<Flight> findByProvider(String provider);
}
