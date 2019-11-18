package org.nagarro.tanzeem.casinoAdmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_TABLE")
public class Customer {
	
	@Id
	@Column(name="CUSTOMER_UNIQUE_ID")
	String uniqueId;
	
	@Column(name="CUSTOMER_NAME")
	String custName;
	
	@Column(name="CUSTOMER_DOB")
	String custDob;
	
	@Column(name="CUSTOMER_CONTACT")
	String custContact;
	
	@Column(name="CUSTOMER_EMAIL")
	String custEmail;
	
	@Column(name="CUSTOMER_IDENTITY_PROOF")
	String custIdProof;
	
	@Column(name="CUSTOMER_ACCOUNT_BALANCE")
	int custAccountBalance;
	
	@Column(name="CUSTOMER_BLOCKED_AMOUNT")
	int custBlockedAmt;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustDob() {
		return custDob;
	}

	public void setCustDob(String custDob) {
		this.custDob = custDob;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustIdProof() {
		return custIdProof;
	}

	public void setCustIdProof(String custIdProof) {
		this.custIdProof = custIdProof;
	}

	public int getCustAccountBalance() {
		return custAccountBalance;
	}

	public void setCustAccountBalance(int custAccountBalance) {
		this.custAccountBalance = custAccountBalance;
	}

	public int getCustBlockedAmt() {
		return custBlockedAmt;
	}

	public void setCustBlockedAmt(int custBlockedAmt) {
		this.custBlockedAmt = custBlockedAmt;
	}	

}
