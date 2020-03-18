package com.hcl.bank.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FundTransfer")
public class FundTransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="fund_transfer_id")
	private Long fundTransferId;
	
	@Column(name="to_account")
	private Long toAccount;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="fundTransferDateTime")
	private LocalDateTime fundTransferDateTime;
	
	@Column(name="fromAccount")
	private Long fromAccount;
	
	public FundTransfer(Long toAccount, double amount,Long fromAccount) {

		this.toAccount = toAccount;
		this.amount = amount;
		this.fundTransferDateTime = LocalDateTime.now();
		this.fromAccount = fromAccount;
	}

	public Long getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(Long fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getFundTransferDateTime() {
		return fundTransferDateTime;
	}

	public void setFundTransferDateTime(LocalDateTime fundTransferDateTime) {
		this.fundTransferDateTime = fundTransferDateTime;
	}

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}


}
