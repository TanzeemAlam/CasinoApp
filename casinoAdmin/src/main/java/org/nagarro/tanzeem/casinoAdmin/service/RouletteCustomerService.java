package org.nagarro.tanzeem.casinoAdmin.service;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.nagarro.tanzeem.casinoAdmin.dto.CustomerDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RouletteCustomerService {

	public CustomerDTO getRouletteCustomerDTO(String id) throws JSONException {

		String url = "http://localhost:9999/casinoAdmin/admin/api/customer/" + id;
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("", header);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		List<String> list = Arrays.asList(response.getBody());
	
		if (list.get(0) == null) {
			return null;
		}
		else {
			JSONObject obj = new JSONObject(list.get(0));

			String customerId = (String) obj.get("uniqueId");
			String customerName = (String) obj.get("custName");
			int customerBalance = (int) obj.get("custAccountBalance");
			int customerBlockAmt = (int) obj.get("custBlockedAmt");

			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setUniqueId(customerId);
			customerDTO.setCustName(customerName);
			customerDTO.setCustAccountBalance(customerBalance);
			customerDTO.setCustBlockedAmt(customerBlockAmt);

			return customerDTO;
		}
	}

}
