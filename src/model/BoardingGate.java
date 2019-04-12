package model;

import java.util.Comparator;

public class BoardingGate implements Comparator<Flight>{
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Flight o1, Flight o2) {
		return o1.getBoardingGate()-o2.getBoardingGate();
	}

}
