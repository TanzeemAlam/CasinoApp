package org.nagarro.tanzeem.casinoAdmin.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nagarro.tanzeem.casinoAdmin.model.Customer;
import org.nagarro.tanzeem.casinoAdmin.sessionConfiguration.SessionUtil;
import org.springframework.stereotype.Component;

@Component
public class RechargeBalanceService {
	
	public void rechargeBalance(String custKey, int amountToAdd) {
		
		System.out.println("In recharge balance service");
			
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, custKey);
		
		int prevBalance = customer.getCustAccountBalance();
		
		customer.setCustAccountBalance(prevBalance + amountToAdd); 
		
		session.update(customer);
		tx.commit();
		session.close();
		System.out.println("Customer Balance Updated!");
	}

}
