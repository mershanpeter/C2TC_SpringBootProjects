package com.tnsif.SpringIOC;



import org.springframework.stereotype.Component;

@Component
public class Food implements ShoppingMall{
	public void purchase() {
		System.out.println("I am ordering food");
	}
}
