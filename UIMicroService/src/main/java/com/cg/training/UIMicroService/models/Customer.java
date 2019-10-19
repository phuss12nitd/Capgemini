package com.cg.training.UIMicroService.models;



import org.springframework.stereotype.Component;

@Component
public class Customer {

	public long id;
	public String name;
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
