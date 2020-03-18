package com.hcl.bank.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "select * from transaction where accounts_account_id =?",nativeQuery = true)
	List<Transaction> findByAccounts(Long accounts);

}
