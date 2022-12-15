package com.sunshine.dao;

import java.util.List;

import com.sunshine.exception.BusException;
import com.sunshine.model.Bus;
import com.sunshine.model.CustomerDTO3;

public interface BusDAO {
	public String addNewBus(Bus bus) throws BusException;
	
	public String cancelBus(int busID) throws BusException;
	
	public List<CustomerDTO3> showAllCustomersByBus(int busID) throws BusException;
}
