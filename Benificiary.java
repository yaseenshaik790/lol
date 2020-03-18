package com.hcl.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="benificiary")
public class Benificiary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="benificiary_id")
	private Long benificiaryId;
	
	@Column(name="benificiary_account_number")
	private Long benificiaryAccountNumber;
	
	@Column(name="benificiary_name")
	private String benificiaryName;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	private Customer customer;

	public Long getBenificiaryAccountNumber() {
		return benificiaryAccountNumber;
	}

	public void setBenificiaryAccountNumber(Long benificiaryAccountNumber) {
		this.benificiaryAccountNumber = benificiaryAccountNumber;
	}

	public Long getBenificiaryId() {
		return benificiaryId;
	}

	public void setBenificiaryId(Long benificiaryId) {
		this.benificiaryId = benificiaryId;
	}

	public String getBenificiaryName() {
		return benificiaryName;
	}

	public void setBenificiaryName(String benificiaryName) {
		this.benificiaryName = benificiaryName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
}
