package com.rental.service.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AcCostRepositoryImpl implements AcCostRepository {

	public Float getAcCost() {
		return 2F;
	}

}
