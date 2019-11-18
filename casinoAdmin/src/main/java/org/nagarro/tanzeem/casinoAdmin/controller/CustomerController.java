package org.nagarro.tanzeem.casinoAdmin.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.nagarro.tanzeem.casinoAdmin.dto.CustomerDTO;
import org.nagarro.tanzeem.casinoAdmin.model.Customer;
import org.nagarro.tanzeem.casinoAdmin.sessionConfiguration.SessionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

	@GetMapping("/admin/api/customer/{id}")
	public CustomerDTO getCustomer(@PathVariable("id") String id) {
		
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, id);
		
		if(customer == null)
			return null;
		else {
			CustomerDTO customerDTO = new CustomerDTO();
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(customer,customerDTO);
			
			tx.commit();
			session.close();
			System.out.println(customerDTO);
			return customerDTO;
		}
		
	}
	
	@GetMapping("/admin/api/customer/{id}/balanceUpdate/{updatedBalance}")
	public CustomerDTO updateCustomerBalance(@PathVariable("id") String id, 
			@PathVariable("updatedBalance") String updatedBalance) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, id);
		
		customer.setCustAccountBalance(Integer.parseInt(updatedBalance));
		
		session.update(customer);
		
		System.out.println("Updated Balance" + customer.getCustAccountBalance());
		
		tx.commit();
		session.close();

		
		return null;
	}
	
	@GetMapping("/admin/api/customer/{id}/blockAmount/{amountToBlock}")
	public CustomerDTO updateCustomerBlockAmount(@PathVariable("id") String id, 
			@PathVariable("amountToBlock") String updatedBlockAmount) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, id);
		
		customer.setCustBlockedAmt(Integer.parseInt(updatedBlockAmount));
		
		session.update(customer);
		
		
		tx.commit();
		session.close();

		
		return null;
	}
}
