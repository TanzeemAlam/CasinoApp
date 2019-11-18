package org.nagarro.tanzeem.casinoAdmin.service;

import java.util.List;

import org.hibernate.Session;
import org.nagarro.tanzeem.casinoAdmin.model.Customer;
import org.nagarro.tanzeem.casinoAdmin.sessionConfiguration.SessionUtil;
import org.springframework.stereotype.Component;

@Component
public class LoadUserDataService {
	
	public List<Customer> getAllCustomerData(){
		
		Session session = SessionUtil.getSession();
		
		String queryString = "select * from CUSTOMER_TABLE";
		
		List<Customer> result =session.createSQLQuery(queryString).addEntity(Customer.class).list();
		
		return result;
	}

}
