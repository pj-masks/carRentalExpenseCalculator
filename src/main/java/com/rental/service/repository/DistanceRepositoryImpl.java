package com.rental.service.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rental.model.CityPair;

@Repository
public class DistanceRepositoryImpl implements DistanceRepository {

	private Map<CityPair, Float> cityPairDistances = new HashMap<>();

	public DistanceRepositoryImpl() {
		cityPairDistances.put(new CityPair("Bangalore", "Chennai"), 300F);
		cityPairDistances.put(new CityPair("Bangalore", "Delhi"), 2100F);
		cityPairDistances.put(new CityPair("Bangalore", "Mumbai"), 1000F);
		cityPairDistances.put(new CityPair("Bangalore", "Pune"), 800F);
		cityPairDistances.put(new CityPair("Chennai", "Delhi"), 2200F);
		cityPairDistances.put(new CityPair("Chennai", "Mumbai"), 1300F);
		cityPairDistances.put(new CityPair("Chennai", "Pune"), 1200F);
		cityPairDistances.put(new CityPair("Delhi", "Mumbai"), 1400F);
		cityPairDistances.put(new CityPair("Delhi", "Pune"), 1500F);
		cityPairDistances.put(new CityPair("Mumbai", "Pune"), 100F);
	}

	public Float getDistance(CityPair pair) {
		return cityPairDistances.get(pair);
	}

}
