
package com.hcl.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.bank.dto.BenificiaryDTO;
import com.hcl.bank.dto.BenificiaryRequest;
import com.hcl.bank.dto.CustomerDto;
import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.Benificiary;
import com.hcl.bank.entity.Customer;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.exception.BenificiaryNotFoundException;
import com.hcl.bank.exception.CustomerNotLoggedInException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.BenificiaryRepository;
import com.hcl.bank.repository.CustomerRepository;

@Service
public class BenificiaryService {

	@Autowired
	BenificiaryRepository benificiaryRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;

	Logger log = LoggerFactory.getLogger(BenificiaryService.class);

	@Transactional
	public String addBenificiary(BenificiaryDTO benificiaryDto)
			throws UserNotFoundException, AccountNotFoundException, BeansException, CustomerNotLoggedInException {

			Account account = accountRepository.findByAccount(benificiaryDto.getBenificiaryAccountNumber());

			if (account != null) {
				throw new AccountNotFoundException("account is already exist");
			}

			Benificiary benificiary = new Benificiary();
			benificiary.setBenificiaryAccountNumber(benificiaryDto.getBenificiaryAccountNumber());
			benificiary.setBenificiaryName(benificiaryDto.getBenificiaryName());

			Customer customer = customerRepository.findByCustomerId(benificiaryDto.getCustomerId());
			List<Benificiary> benificiaries = new ArrayList<Benificiary>();
			benificiaries.add(benificiary);

			customer.setBenificiaries(benificiaries);
			CustomerDto customerDto = new CustomerDto();

			BeanUtils.copyProperties(customerDto, customer);
			benificiary.setCustomer(customer);

			customerRepository.save(customer);
			log.info("Benificiary added successfully.");
			
			return "success";

	}

	public void updatedBenificiary(BenificiaryDTO benificiaryRequest)
			throws BenificiaryNotFoundException, UserNotFoundException {

//		Optional<Benificiary> benificiary = benificiaryRepository
//				.findByBenificiaryId(benificiaryRequest.getBenificiaryId());
//		if (benificiary.isPresent()) {
//
//			benificiary.get().setBenificiaryAccountNumber(benificiaryRequest.getBenificiaryAccountNumber());
//			benificiary.get().setBenificiaryName(benificiaryRequest.getBenificiaryName());
//
//			CustomerDto customerDto = customerService.findCustomerByCustomerId(benificiaryRequest.getCustomerId());
//
//			Customer customer = new Customer();
//
//			BeanUtils.copyProperties(customerDto, customer);
//			benificiary.get().setCustomer(customer);
//
//			benificiaryRepository.save(benificiary.get());
//			log.info("Benificiary added successfully.");
//		} else {
//			throw new BenificiaryNotFoundException("benificiary not found exception");
//		}

	}

	public void deleteBenificiary(Long benificiaryId) throws BenificiaryNotFoundException {

		/*
		 * Optional<Benificiary> benificiary =
		 * benificiaryRepository.findByBenificiaryId(benificiaryId); if
		 * (benificiary.isPresent()) {
		 * benificiaryRepository.deleteById(benificiary.get().getBenificiaryId()); }
		 * else { throw new
		 * BenificiaryNotFoundException("benificiary not found exception"); }
		 * 
		 */	}

	public BenificiaryDTO getBenificiaryByBenificiaryId(Long benificiaryId) throws BenificiaryNotFoundException {
		return null;
		/*
		 * Optional<Benificiary> benificiary =
		 * benificiaryRepository.findByBenificiaryId(benificiaryId); if
		 * (benificiary.isPresent()) { BenificiaryDTO benificiaryDto = new
		 * BenificiaryDTO();
		 * benificiaryDto.setBenificiaryId(benificiary.get().getBenificiaryId());
		 * benificiaryDto.setBenificiaryAccountNumber(benificiary.get().
		 * getBenificiaryAccountNumber());
		 * benificiaryDto.setBenificiaryName(benificiary.get().getBenificiaryName());
		 * benificiaryDto.setCustomerId(benificiary.get().getCustomer().getCustomerId())
		 * ; return benificiaryDto; } else { throw new
		 * BenificiaryNotFoundException("benificiary not found exception"); }
		 */
	}

	/*
	 * @Override public List<BenificiaryDTO> getAllBenificiaryByCustomerId(Long
	 * customerId) throws BenificiaryNotFoundException { List<Benificiary>
	 * benificiary = benificiaryRepository.findByCustomer(customerId));
	 * if(CollectionUtils.isEmpty(benificiary)) {
	 * 
	 * }
	 * 
	 * 
	 * return benificiary; }
	 */

}
