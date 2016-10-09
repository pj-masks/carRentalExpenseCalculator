package com.rental.service.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.rental.model.CityPair;

public class IteneraryToCityPairSplitterImplTest {

	private IteneraryToCityPairSplitterImpl iteneraryToCityPairSplitterImpl = new IteneraryToCityPairSplitterImpl();;

	@Test
	public void testSplitReturnsOneCityPairWhenIteneraryHasTwoCities() {
		List<CityPair> result = iteneraryToCityPairSplitterImpl.split("Bangalore-Chennai");
		assertEquals(1, result.size());
		assertEquals(new CityPair("Bangalore", "Chennai"), result.get(0));
	}

	@Test
	public void testSplitReturnsTwoCityPairsWhenIteneraryHasThreeCities() {
		List<CityPair> result = iteneraryToCityPairSplitterImpl.split("Pune-Bangalore-Chennai");
		assertEquals(2, result.size());
		assertEquals(new CityPair("Pune", "Bangalore"), result.get(0));
		assertEquals(new CityPair("Bangalore", "Chennai"), result.get(1));
	}

}
