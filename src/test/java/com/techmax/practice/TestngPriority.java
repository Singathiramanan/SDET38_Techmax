package com.techmax.practice;

import org.testng.annotations.Test;

public class TestngPriority {
	@Test
	public void createSup(){
		System.out.println("Supplier is created");
	}
	@Test(priority=1)
	public void createProduct(){
		System.out.println("Product is created");
	}
	@Test(priority=2)
	public void editProduct(){
		System.out.println("Product is edited");
	}
}
