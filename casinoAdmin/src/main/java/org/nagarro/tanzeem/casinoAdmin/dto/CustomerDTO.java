package org.nagarro.tanzeem.casinoAdmin.dto;

public class CustomerDTO {

	String uniqueId;
	String custName;
	int custAccountBalance;
	int custBlockedAmt;
	public int getCustBlockedAmt() {
		return custBlockedAmt;
	}
	public void setCustBlockedAmt(int custBlockedAmt) {
		this.custBlockedAmt = custBlockedAmt;
	}
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
	
	public int getCustAccountBalance() {
		return custAccountBalance;
	}
	public void setCustAccountBalance(int custAccountBalance) {
		this.custAccountBalance = custAccountBalance;
	}
	
//	Customer customer = new Customer();
//	CustomerDTO customerDTO = new CustomerDTO();
//	ModelMapper modelMapper = new ModelMapper();
//	modelMapper.map(customer,customerDTO);
	
}
