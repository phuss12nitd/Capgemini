package com.capgemini.training.demo.custController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.demo.model.Customer;

@RestController
public class custController {
	
	@Autowired
	Customer cust;
	
	public String index() {
		return "Hello World";
	}
}
