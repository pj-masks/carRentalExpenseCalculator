package com.rental.service.repository;

import com.rental.model.FuelType;

public interface FuelCostRepository {

	Float getFuelCost(FuelType fuelType);

}
