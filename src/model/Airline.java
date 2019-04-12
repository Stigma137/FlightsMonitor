package model;

import java.util.Comparator;

public class Airline implements Comparator<Flight>{
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Flight o1, Flight o2) {
		return o1.getAirLine().compareTo(o2.getAirLine());
	}
}
