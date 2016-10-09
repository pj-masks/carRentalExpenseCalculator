package com.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.model.CityPair;
import com.rental.model.Trip;
import com.rental.model.VehicleType;
import com.rental.service.repository.AcCostRepository;
import com.rental.service.repository.BusDiscountRepository;
import com.rental.service.repository.DistanceRepository;
import com.rental.service.repository.FuelCostRepository;
import com.rental.service.util.IteneraryToCityPairSplitter;

@Service
public class TotalExpenseService {

	private final DistanceRepository distanceRepository;
	private final FuelCostRepository fuelCostRepository;
	private final AcCostRepository acCostRepository;
	private final BusDiscountRepository busDiscountRepository;
	private final IteneraryToCityPairSplitter iteneraryToCityPairSplitter;

	@Autowired
	public TotalExpenseService(final IteneraryToCityPairSplitter iteneraryToCityPairSplitter,
			final DistanceRepository distanceRepository, final FuelCostRepository fuelCostRepository,
			final AcCostRepository acCostRepository, final BusDiscountRepository busDiscountRepository) {
		this.iteneraryToCityPairSplitter = iteneraryToCityPairSplitter;
		this.distanceRepository = distanceRepository;
		this.fuelCostRepository = fuelCostRepository;
		this.acCostRepository = acCostRepository;
		this.busDiscountRepository = busDiscountRepository;
	}

	public Float calculate(final Trip trip) {
		List<CityPair> cityPairs = getCityPairs(trip);
		Float totalDistance = cityPairs.parallelStream().map(cityPair -> getDistanceBetweenCities(cityPair))
				.reduce(Float::sum).get();
		Float fuelCostPerKm = getFuelCost(trip) + getAcCost(trip);
		Float busDiscountCoefficient = getBusDiscount(trip);
		Float totalExpense = totalDistance * fuelCostPerKm * busDiscountCoefficient;
		return totalExpense;

	}

	private List<CityPair> getCityPairs(final Trip trip) {
		return iteneraryToCityPairSplitter.split(trip.getItenerary());
	}

	private Float getBusDiscount(final Trip trip) {
		return trip.getVehicleType() == VehicleType.BUS ? busDiscountRepository.getBusDiscountCoeficient() : 1.0F;
	}

	private Float getAcCost(final Trip trip) {
		return trip.isAc() ? acCostRepository.getAcCost() : 0;
	}

	private Float getFuelCost(final Trip trip) {
		return fuelCostRepository.getFuelCost(trip.getFuelType());
	}

	private Float getDistanceBetweenCities(final CityPair cityPair) {
		return distanceRepository.getDistance(cityPair);
	}

}
