package com.hcl.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.dto.BenificiaryDTO;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.exception.CustomerNotLoggedInException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.service.BenificiaryService;

@RestController
@RequestMapping("/benificiaries")
public class BenificiaryController {

	private Logger logger = LoggerFactory.getLogger(BenificiaryController.class);

	@Autowired
	private BenificiaryService benificiaryService;

	@PutMapping("")
	public ResponseEntity<String> addBenificiary(@RequestBody BenificiaryDTO benificiaryDto)
			throws UserNotFoundException, BeansException, AccountNotFoundException, CustomerNotLoggedInException {

		logger.info(" adding benificiary ");

		String customerLogin = benificiaryService.addBenificiary(benificiaryDto);

		return new ResponseEntity<String>(customerLogin, HttpStatus.OK);
	}

}
