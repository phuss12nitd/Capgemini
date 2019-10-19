package com.cg.training.restDemo.custController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.restDemo.model.Customer;
import com.cg.training.restDemo.repo.CustRepo;

@RestController
public class custController {
	@Autowired
	Optional<Customer> cust;

	@Autowired
	CustRepo repo;
	
	@GetMapping("/customers/{id}")
	public Optional<Customer> displayById(@PathVariable("id") long id) {
		cust = repo.findById(id);
		return cust;
	}
	
	@GetMapping("/customers")
	public Iterable<Customer> displayAll(){
		return repo.findAll();
	}
	
	@PostMapping("/customers")
	public String add(@RequestBody Customer cust1) {
		repo.save(cust1);
		return "Record added Successfully";
	}
	
	@PutMapping("/customers/{id}")
	public String update(@RequestBody Customer cust1, @PathVariable("id") long id) {
		cust1.setId(id);
		repo.save(cust1);
		return "Record updated Successfully";
	}
	@DeleteMapping("/customers/{id}")
	public String delete(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "Record was deleted Successfully";
	}
	
}
