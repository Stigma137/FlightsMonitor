package model;

import java.util.Comparator;

public class Time implements Comparator<Flight>{
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Flight f1, Flight f2) {
		return f1.getTime().compareTo(f2.getTime());
	}		
}
