package com.rental.service.util;

import java.util.List;

import com.rental.model.CityPair;

public interface IteneraryToCityPairSplitter {
	/**
	 * Interface to split an itenerary to List of CityPairs. E.g.
	 * Pune-Bangalore-Chennai becomes two city pairs (Pune,Bangalore) and
	 * (Bangalore,Chennai).
	 * 
	 * @param itenerary
	 * @return List<CityPair>
	 */
	List<CityPair> split(String itenerary);
}
