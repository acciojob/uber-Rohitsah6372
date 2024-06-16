package com.driver.services.impl;

import com.driver.model.*;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Optional<Customer> optinalCustomer = customerRepository2.findById(customerId);

		if(optinalCustomer.isPresent()){
			Customer customer = optinalCustomer.get();
			customerRepository2.delete(customer);
		}else{
			throw new RuntimeException("Error");
		}

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		Driver driver = driverRepository2.findDriverWithLowestId();

		if(!driver.getAvialable()){
			throw  new RuntimeException("No cab available!");
		}
		TripBooking tripBooking= new TripBooking();
		tripBooking.setFromLocation(fromLocation);
		tripBooking.setToLocation(toLocation);
		tripBooking.setDistanceInKm(distanceInKm);
		Cab cab = tripBooking.getCab();

		cab.setAvialable(false);

		return tripBookingRepository2.save(tripBooking);
	}

	@Override
	public void cancelTrip(Integer tripId){
		Optional<TripBooking> optionalTripBooking = tripBookingRepository2.findById(tripId);

		if(optionalTripBooking.isPresent()){
			tripBookingRepository2.delete(optionalTripBooking.get());
		}else{
			throw new RuntimeException("Error");
		}

	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		Optional<TripBooking> optionalTripBooking = tripBookingRepository2.findById(tripId);

		if(optionalTripBooking.isPresent()){
			TripBooking tripBooking = optionalTripBooking.get();
			tripBooking.getCab().setAvialable(true);
			tripBookingRepository2.save(tripBooking);

		}else{
			throw new RuntimeException("Error");
		}

	}
}
