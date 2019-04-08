package model;

public class Flight {
	private String airLine;
	private String date;
	private String time;
	private String destination;
	private int flightNumber;
	private int boardingGate;
	
	public Flight(String airLine, String date, String time, String destination, int flightNumber, int boardingGate) {
		this.airLine = airLine;
		this.boardingGate = boardingGate;
		this.date = date;
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.time = time;
	}

	public String getAirLine() {
		return airLine;
	}

	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getBoardingGate() {
		return boardingGate;
	}

	public void setBoardingGate(int boardingGate) {
		this.boardingGate = boardingGate;
	}
	
}
