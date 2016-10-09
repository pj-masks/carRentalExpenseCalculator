package com.rental.service.repository;

import com.rental.model.CityPair;

public interface DistanceRepository {

	Float getDistance(CityPair pair);

}
