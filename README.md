# carRentalExpenseCalculator

To run the service, use gradle bootRun or mvn spring-boot:run

It accepts JSON POST request with request uri as localhost:8686/calculate-total-expense

example body is

{  
   "vehicleType":"CAR",
   "fuelType":"PETROL",
   "ac":true,
   "itenerary":"Bangalore-Chennai-Bangalore"
}
