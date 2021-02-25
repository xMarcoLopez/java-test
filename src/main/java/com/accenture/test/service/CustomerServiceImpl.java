package com.accenture.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.utils.Utils;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public List<CustomerDTO> getCustomers() {
		return Utils.customers;
	}

}
