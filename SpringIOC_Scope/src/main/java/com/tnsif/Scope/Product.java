package com.tnsif.Scope;

import org.springframework.stereotype.Component;

@Component

public class Product {
	private  int id ;
	private String p_name;
	public Product() {
		System.out.println("Product class obj created !");
	}
}