package com.rental.service.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BusDiscountRepositoryImpl implements BusDiscountRepository {

	public Float getBusDiscountCoeficient() {
		return 0.98F;
	}

}
