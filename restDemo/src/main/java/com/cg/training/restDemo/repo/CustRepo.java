package com.cg.training.restDemo.repo;

import org.springframework.data.repository.CrudRepository;

import com.cg.training.restDemo.model.Customer;

public interface CustRepo extends CrudRepository<Customer, Long>{

}
