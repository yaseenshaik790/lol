package com.hcl.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hcl.bank.dto.Transactiondto;
import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.Transaction;
import com.hcl.bank.repository.TransactionRepository;
import com.hcl.bank.response.TransactionResponse;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository; 
 
	public TransactionResponse getTransactionsStatement(Long accountId) {


		List<Transaction> transactionList = transactionRepository.findByAccounts(accountId);

		List<Transactiondto> transactiondtos = transactionList.stream().map(transactionObj -> {

			Transactiondto transactiondto = new Transactiondto();
			BeanUtils.copyProperties(transactionObj, transactiondto);
			return transactiondto;

		}).collect(Collectors.toList());

		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setFundTransfer(transactiondtos);
		transactionResponse.setSizeOfList(transactiondtos.size());

		return transactionResponse;

	}

}
