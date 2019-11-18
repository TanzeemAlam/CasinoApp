package org.nagarro.tanzeem.casinoAdmin.service;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nagarro.tanzeem.casinoAdmin.model.Customer;
import org.nagarro.tanzeem.casinoAdmin.sessionConfiguration.SessionUtil;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegisterService {
	
	public void registerCustomer(String custName, String custDob, String custContact, String custEmail, 
			String custFile) {
		
		System.out.println("In customer registration service!!!");
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		
		customer.setUniqueId(getSaltString());
		customer.setCustName(custName);
		customer.setCustDob(custDob);
		customer.setCustContact(custContact);
		customer.setCustEmail(custEmail);
		customer.setCustIdProof(custFile.toString());
		customer.setCustAccountBalance(500);
		customer.setCustBlockedAmt(0);
		
		
		session.save(customer);
		tx.commit();
		
		session.close();
		
		System.out.println("New customer registered!");
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
