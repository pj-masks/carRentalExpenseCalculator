package com.rental.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rental.model.CityPair;
import com.rental.model.FuelType;
import com.rental.model.Trip;
import com.rental.model.VehicleType;
import com.rental.service.repository.AcCostRepository;
import com.rental.service.repository.BusDiscountRepository;
import com.rental.service.repository.DistanceRepository;
import com.rental.service.repository.FuelCostRepository;
import com.rental.service.util.IteneraryToCityPairSplitter;

public class TotalExpenseServiceTest {

	@Mock
	private DistanceRepository distanceRepository;
	@Mock
	private FuelCostRepository fuelCostRepository;
	@Mock
	private AcCostRepository acCostRepository;
	@Mock
	private BusDiscountRepository busDiscountRepository;
	@Mock
	private IteneraryToCityPairSplitter iteneraryToCityPairSplitter;

	private TotalExpenseService totalExpenseService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		totalExpenseService = new TotalExpenseService(iteneraryToCityPairSplitter, distanceRepository,
				fuelCostRepository, acCostRepository, busDiscountRepository);
		List<CityPair> cityPairs = new ArrayList<>();
		CityPair puneBangalore = new CityPair("Pune", "Bangalore");
		CityPair bangaloreChennai = new CityPair("Bangalore", "Chennai");
		cityPairs.add(puneBangalore);
		cityPairs.add(bangaloreChennai);
		when(iteneraryToCityPairSplitter.split("Pune-Bangalore-Chennai")).thenReturn(cityPairs);
		when(distanceRepository.getDistance(puneBangalore)).thenReturn(800F);
		when(distanceRepository.getDistance(bangaloreChennai)).thenReturn(300F);
		when(fuelCostRepository.getFuelCost(FuelType.PETROL)).thenReturn(15F);
		when(acCostRepository.getAcCost()).thenReturn(2F);
		when(busDiscountRepository.getBusDiscountCoeficient()).thenReturn(0.98F);
	}

	@Test
	public void testCalculateReturnsExpectedValueForCarAc() {
		Trip trip = new Trip(VehicleType.CAR, FuelType.PETROL, Boolean.TRUE, "Pune-Bangalore-Chennai");
		// (800+300)*(15+2) = 18700
		assertEquals(new Float(18700), totalExpenseService.calculate(trip));
	}

	@Test
	public void testCalculateReturnsExpectedValueForCarNonAc() {
		Trip trip = new Trip(VehicleType.CAR, FuelType.PETROL, Boolean.FALSE, "Pune-Bangalore-Chennai");
		// (800+300)*(15+0) = 16500
		assertEquals(new Float(16500), totalExpenseService.calculate(trip));
	}

	@Test
	public void testCalculateReturnsExpectedValueForBusAc() {
		Trip trip = new Trip(VehicleType.BUS, FuelType.PETROL, Boolean.TRUE, "Pune-Bangalore-Chennai");
		// (800+300)*(15+2)*.98 = 18700
		assertEquals(new Float(18326), totalExpenseService.calculate(trip));
	}

}
