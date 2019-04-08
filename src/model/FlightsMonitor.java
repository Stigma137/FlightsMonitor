package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightsMonitor {
	
	public final static String AIRLINES = "data/airlines.txt";
	public final static String DESTINATIONS = "data/destinations.txt";
	
	public final static int SORTED_BY_AIRLINE = 1;
	public final static int SORTED_BY_BOARDING_GATE = 2;
	public final static int SORTED_BY_DATE = 3;
	public final static int SORTED_BY_DESTINATIONS = 4;
	public final static int SORTED_BY_FLIGHT_NUMBER= 5;
	public final static int SORTED_BY_TIME = 6;
	
	private int sorted;
	private ObservableList<Flight> flights;
	
	public FlightsMonitor(ObservableList<Flight> flights) { 
		this.flights = FXCollections.observableArrayList();
	}
	public ObservableList<Flight> generateFlights(int n) throws IOException {
		if(flights.size() > 0) {
			flights.clear();
		}
		String airline = "";
		String destinations = "";
		int boardGate = 0;
		int flightNumber = 0;
		Calendar date = null;
		String time = null;
		int numLineas=100;
        int contador=0;
        String airLineData []=new String [numLineas];
		BufferedReader reader = new BufferedReader(new FileReader(AIRLINES));
        String linea = reader.readLine();
        while (linea != null && contador<numLineas)
        {
           airLineData[contador]=linea;
           linea = reader.readLine();
           contador++;
        }
        reader.close();
        int numLineas2=196;
        int contador2=0;
        String destinationsData []=new String [numLineas2];
		BufferedReader reader2 = new BufferedReader(new FileReader(DESTINATIONS));
        String linea2 = reader2.readLine();
        while (linea2 != null && contador2<numLineas2)
        {
           destinationsData[contador2]=linea2;
           linea2 = reader2.readLine();
           contador2++;
        }
        reader2.close();
		for (int i = 0; i < n; i++ ) {
			boardGate = (int) (Math.random() * 30) + 1;
			flightNumber = (int) (Math.random() * 10000000) + 1;
	        Random random = new Random();
	        date = Calendar.getInstance();
	        date.set (random.nextInt(10)+2019, random.nextInt(12)+1, random.nextInt(30)+1);
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
	        int h = (int) (Math.random() * 12) + 1;
	        int m = (int) (Math.random() * 59) + 1;
	        if (i%2==0) {
	        	time = h + ":" + m + " PM";
	        } else if (i%2 != 0) {
	        	time = h + ":" + m + " AM";
	        }
	        destinations = (String) destinationsData[(int) (Math.random() * 195) + 1];
	        airline = (String) airLineData[(int) (Math.random() * 99) + 1];
	        Flight f = new Flight(airline, sdf.format(date.getTime()), time, destinations, flightNumber, boardGate);
	        flights.add(f);
		}
		return flights;
	}
}	
