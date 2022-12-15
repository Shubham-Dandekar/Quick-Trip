package com.sunshine.dao;

import java.util.List;

import com.sunshine.exception.BusException;
import com.sunshine.exception.CustomerException;
import com.sunshine.model.Bus;
import com.sunshine.model.Customer;

public interface BusDAO {
	public String addNewBus(Bus bus) throws BusException;
	
	public List<Bus> showAllBus() throws BusException;
	
	public List<Customer> showAllCustomersByBus(int busID) throws CustomerException;
}
