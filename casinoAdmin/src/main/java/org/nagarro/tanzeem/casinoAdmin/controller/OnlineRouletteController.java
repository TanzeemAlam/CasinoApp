package org.nagarro.tanzeem.casinoAdmin.controller;

import org.json.JSONException;
import org.nagarro.tanzeem.casinoAdmin.dto.CustomerDTO;
import org.nagarro.tanzeem.casinoAdmin.service.RouletteCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin()
@RestController
public class OnlineRouletteController {

	@Autowired
	RouletteCustomerService rouletteCustomerService;

	@GetMapping("/roulette/api/rouletteCustomer/{id}")
	public CustomerDTO getRouletteCustomer(@PathVariable("id") String id) throws JSONException {

		return rouletteCustomerService.getRouletteCustomerDTO(id);
	}

	@GetMapping("/roulette/api/rouletteCustomer/{id}/balanceUpdate/{updatedBalance}")
	public String updateRouletteCustomerBalance(@PathVariable("id") String id,
			@PathVariable("updatedBalance") String updatedBalance) {

		String url = "http://localhost:9999/casinoAdmin/admin/api/customer/" + id + "/balanceUpdate/" + updatedBalance;

		RestTemplate getRestTemplate = new RestTemplate();
		String result = getRestTemplate.getForObject(url, String.class);
		System.out.println(result);

		return result;
	}
	
	@GetMapping("/roulette/api/rouletteCustomer/{id}/blockAmount/{amountToBlock}")
	public String updateRouletteCustomerBlockAmount(@PathVariable("id") String id,
			@PathVariable("amountToBlock") String updatedBlockAmount) {

		String url = "http://localhost:9999/casinoAdmin/admin/api/customer/" + id + "/blockAmount/" + updatedBlockAmount;

		RestTemplate getRestTemplate = new RestTemplate();
		String result = getRestTemplate.getForObject(url, String.class);
		System.out.println(result);

		return result;
	}
}
