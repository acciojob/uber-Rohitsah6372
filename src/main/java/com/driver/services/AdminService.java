package com.driver.services;

import java.util.List;

import com.driver.model.Admin;
import com.driver.model.Customer;
import com.driver.model.Driver;

public interface AdminService {

	void adminRegister(Admin admin);

	Admin updatePassword(Integer adminId, String password);

	void deleteAdmin(int adminId);

	List<Driver> getListOfDrivers();
	
	List<Customer> getListOfCustomers();
}
