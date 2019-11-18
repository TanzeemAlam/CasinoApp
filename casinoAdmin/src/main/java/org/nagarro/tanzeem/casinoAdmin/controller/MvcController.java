package org.nagarro.tanzeem.casinoAdmin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nagarro.tanzeem.casinoAdmin.service.CustomerRegisterService;
import org.nagarro.tanzeem.casinoAdmin.service.LoadUserDataService;
import org.nagarro.tanzeem.casinoAdmin.service.RechargeBalanceService;
import org.nagarro.tanzeem.casinoAdmin.sessionConfiguration.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Session;
import org.nagarro.tanzeem.casinoAdmin.model.Customer;

@Controller
public class MvcController {

	@Autowired
	CustomerRegisterService custRegisterService;

	@Autowired
	LoadUserDataService loadUserDataService;

	@Autowired
	RechargeBalanceService rechargeBalanceService;

	List<Customer> userList = new ArrayList<Customer>();

	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");

		System.out.println("At home page!!");

		return mv;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("userList")
	public ModelAndView showList() {
		ModelAndView mv = new ModelAndView();
		
		Session session = SessionUtil.getSession();
		List<Customer> userList;
		
		userList = session
				.createSQLQuery("select * from CUSTOMER_TABLE")
				.addEntity(Customer.class).list();

		mv.setViewName("userList.jsp");
		mv.addObject("usersList", userList);
		
		
		return mv;
	}

	@RequestMapping("registerCustomer")
	public ModelAndView registerCustomer(@RequestParam("name") String custName, @RequestParam("dob") String custDob,
			@RequestParam("contact") String custContact, @RequestParam("email") String custEmail,
			@RequestParam("file") File file, HttpServletRequest request,
			HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();
		System.out.println("In register customer controller!! ");

		String fileName = file.getName();
		System.out.println(fileName);
		//String path = "C:\\Users\\tanzeemalam\\eclipse-workspace\\casinoAdmin\\src\\main\\resources\\images\\";

//		String newPath = session.getServletContext().getRealPath("/");
//		try {
//			
//			byte barr[] = file.getBytes();
//			
//			BufferedOutputStream bout  = new BufferedOutputStream(
//					new FileOutputStream(newPath + "/" +fileName));
//			Object o = bout;
//			bout.write(barr);
//			bout.flush();
//			bout.close();
//			
//		}catch(Exception e) {
//			System.out.println(e);
//		}

		custRegisterService.registerCustomer(custName, custDob, custContact, custEmail, fileName);

		mv.setViewName("register.jsp");

		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("search")
	public ModelAndView searchCustomer(@RequestParam("name") String searchName,
			@RequestParam("contact") String searchContact, @RequestParam("email") String searchEmail) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("searchName", searchName);
		mv.addObject("searchContact", searchContact);
		mv.addObject("searchEmail", searchEmail);
		
		Session session = SessionUtil.getSession();
		List<Customer> userList;
		
		userList = session
				.createSQLQuery("select * from CUSTOMER_TABLE where CUSTOMER_NAME=:name"
						+ " and CUSTOMER_CONTACT=:contact and CUSTOMER_EMAIL=:email")
				.addEntity(Customer.class).setParameter("name", searchName)
				.setParameter("contact", searchContact)
				.setParameter("email", searchEmail).list();

		mv.setViewName("userList.jsp");
		mv.addObject("usersList", userList);
		
		System.out.println();

		return mv;
	}

	@RequestMapping("rechargeBalance")
	public String rechargeCustomerBalance( 
			@RequestParam("amount") int amountToAdd,
			@RequestParam("secretKey") String key) {

		//ModelAndView mv = new ModelAndView();
		System.out.println("Unique Id: " + key);
		System.out.println("Amount: " + String.valueOf(amountToAdd));

		rechargeBalanceService.rechargeBalance(key, amountToAdd);

		//mv.setViewName("userList.jsp");
		return "redirect:/userList";

	}

}
