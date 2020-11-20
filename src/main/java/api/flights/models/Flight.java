package api.flights.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue
	private int id;

	@NotBlank
	private String provider;

	@NotBlank
	private int price;

	@NotBlank
	private String startTime;

	@NotBlank
	private String endTime;

	@NotBlank
	private String start;

	@NotBlank
	private String end;

	@NotBlank
	private int duration;

	public Flight() {
		super();
	}

	public Flight(
			int id,
			String provider,
			int price,
			String startTime,
			String endTime,
			String start,
			String end,
			int duration
	) {
		super();
		this.id = id;
		this.provider = provider;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.start = start;
		this.end = end;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
