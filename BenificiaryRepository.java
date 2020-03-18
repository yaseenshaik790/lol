package com.hcl.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.Benificiary;

@Repository
public interface BenificiaryRepository extends JpaRepository<Benificiary,Long> {

	Optional<Benificiary> findByBenificiaryId(Long benificiaryId);

}
