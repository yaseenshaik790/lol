package com.hcl.bank.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.dto.CustomerDto;
import com.hcl.bank.entity.Customer;
import com.hcl.bank.exception.CustomerNotLoggedInException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public String customerLogin(String emailId, String password) throws UserNotFoundException {

		Optional<Customer> customer = customerRepository.findByCustomerEmailIdAndPassword(emailId, password);

		if (!customer.isPresent()) {
			throw new UserNotFoundException("user not found exception");
		}

		customer.get().setIsLoggedIn(true);

		customerRepository.save(customer.get());

		return "login successfull";
	}

	public Boolean checkLoggingStatus(Long customerId) throws CustomerNotLoggedInException, UserNotFoundException {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer == null) {
			throw new UserNotFoundException("user not found exception");
		} else {
			return customer.getIsLoggedIn();
		}
	}

	public CustomerDto findCustomerByCustomerId(Long customerId) throws UserNotFoundException {

		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer == null) {
			throw new UserNotFoundException("user not found exception");
		}
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;
	}

}
