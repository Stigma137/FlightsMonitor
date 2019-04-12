package testModel;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import model.Flight;


class testFlight {
	private Flight f;
	public void setupScenary1() {
		
	}
	@Test
	void testFlightContructor() {
		setupScenary1();
		f = new Flight("Avianca", "22/July/2020", "10:45 PM", "Bogota", 4343535, 12);
		assertNotNull("The object has been created correctly", f);
	}

}
