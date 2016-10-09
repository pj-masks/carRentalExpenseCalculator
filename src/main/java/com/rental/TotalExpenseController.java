package com.rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rental.model.Trip;
import com.rental.service.TotalExpenseService;

@RestController
public class TotalExpenseController {

	private final TotalExpenseService totalExpenseService;

	@Autowired
	public TotalExpenseController(final TotalExpenseService totalExpenseService) {
		this.totalExpenseService = totalExpenseService;
	}

	@RequestMapping(value = "/calculate-total-expense", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Float> calculate(@RequestBody Trip trip) {
		return new ResponseEntity<Float>(totalExpenseService.calculate(trip), HttpStatus.OK);
	}
}