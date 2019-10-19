package com.cg.training.UIMicroService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cg.training.UIMicroService.models.Customer;

@Controller
public class uiController {
	
	@Autowired
	RestTemplate restTemp;
	
	@Autowired
	Customer cust;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/customers/{id}")
	public Customer display(@PathVariable("id") int id) {
		return restTemp.getForObject("http://CUSTOMERCRUD/customers/" + id, Customer.class);
	}
	
	
	@GetMapping("/customers")
	public String displayAll(Model model) {
		Customer[] custArray = restTemp.getForObject("http://CUSTOMERCRUD/customers/", Customer[].class);
		model.addAttribute("customers", custArray);
		return "customers";
	}

}
