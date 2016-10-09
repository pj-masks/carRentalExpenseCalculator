package com.rental.service.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rental.model.FuelType;

@Repository
public class FuelCostRepositoryImpl implements FuelCostRepository {

	private Map<FuelType, Float> pricesByFuelType = new HashMap<>();

	public FuelCostRepositoryImpl() {
		pricesByFuelType.put(FuelType.DIESEL, 14F);
		pricesByFuelType.put(FuelType.PETROL, 15F);
	}

	public Float getFuelCost(FuelType fuelType) {
		return pricesByFuelType.get(fuelType);
	}

}
