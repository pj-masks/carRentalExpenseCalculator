package com.rental.model;

/**
 * Class to represent pair of Cities. This gets used to calculate distances
 * between cities. Because of that city pairs are equal irrespective of their
 * order, i.e. Bangalore-Chennai is equal to Chennai-Bangalore, since the
 * distance of those city pairs are same. equals and hashCode methods have been
 * overridden accordingly.
 * 
 * @author pkj
 *
 */
public class CityPair {

	private String start;
	private String end;

	public CityPair(String start, String end) {
		this.start = start;
		this.end = end;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CityPair))
			return false;
		CityPair pairo = (CityPair) o;
		if (this.start.equals(pairo.getStart()) && this.end.equals(pairo.getEnd()))
			return true;
		if (this.start.equals(pairo.getEnd()) && this.end.equals(pairo.getStart()))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return start.hashCode() * end.hashCode();
	}

}
