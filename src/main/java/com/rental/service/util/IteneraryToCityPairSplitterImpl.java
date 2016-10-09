package com.rental.service.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rental.model.CityPair;

@Component
public class IteneraryToCityPairSplitterImpl implements IteneraryToCityPairSplitter {

	public List<CityPair> split(String itenerary) {

		List<CityPair> cityPairs = new ArrayList<>();
		List<String> cities = Arrays.asList(itenerary.split("-"));
		String startPoint = cities.get(0);
		String endPoint;
		for (int i = 1; i <= cities.size() - 1; i++) {
			endPoint = cities.get(i);
			cityPairs.add(new CityPair(startPoint, endPoint));
			startPoint = endPoint;
		}
		return cityPairs;

	}

}
