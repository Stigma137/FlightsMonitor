package model;


public class Flight implements Comparable<Flight>{
	//Attributes
	private String airLine;
	private String date;
	private String time;
	private String destination;
	private int flightNumber;
	private int boardingGate;
	
	/* Method that allows to create an instance of an object of Flight type.
	 * @param a String that represents the flight airline.
	 * @param a String that represents the flight date.
	 * @param a String that represents the flight time.
	 * @param a String that represents the flight destination.
	 * @param an integer that indicates the flight number id.
	 * @param an integer that indicates the flight number boarding gate.
	 */
	public Flight(String airLine, String date, String time, String destination, int flightNumber, int boardingGate) {
		this.airLine = airLine;
		this.boardingGate = boardingGate;
		this.date = date;
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.time = time;
	}
	/* Method that allows to obtain a String that represents the flight airline.
	 * @return a String that represents the flight airline.
	 */
	public String getAirLine() {
		return airLine;
	}
	/* Method that allows to set a String that represents the flight airline.
	 * @param a String that represents the flight airline.
	 */
	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}
	/* Method that allows to obtain a String that represents the flight date.
	 * @return a String that represents the flight date.
	 */
	public String getDate() {
		return date;
	}
	/* Method that allows to set a String that represents the flight date.
	 * @param a String that represents the flight date.
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/* Method that allows to obtain a String that represents the flight time.
	 * @return a String that represents the flight airline.
	 */
	public String getTime() {
		return time;
	}
	/* Method that allows to set a String that represents the flight time.
	 * @param a String that represents the flight airline.
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/* Method that allows to obtain a String that represents the flight destination.
	 * @return a String that represents the flight destination.
	 */
	public String getDestination() {
		return destination;
	}
	/* Method that allows to obtain a String that represents the flight destination.
	 * @param a String that represents the flight destination.
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/* Method that allows to obtain an integer that indicates the flight number id.
	 * @return an integer that indicates the flight number id.
	 */
	public int getFlightNumber() {
		return flightNumber;
	}
	/* Method that allows to set an integer that indicates the flight number id.
	 * @param an integer that indicates the flight number id.
	 */
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	/* Method that allows to obtain an integer that indicates the flight number boarding gate.
	 * @return an integer that indicates the flight number boarding gate.
	 */
	public int getBoardingGate() {
		return boardingGate;
	}
	/* Method that allows to set an integer that indicates the flight number boarding gate.
	 * @param an integer that indicates the flight number boarding gate.
	 */
	public void setBoardingGate(int boardingGate) {
		this.boardingGate = boardingGate;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Airline = " + airLine + ", Date = " + date + ", Time = " + time + ", Destination = " + destination
				+ ", Flight Number = " + flightNumber + ", Boarding Gate = " + boardingGate;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Flight f) {
		return this.date.compareTo(f.date);
	}
}
