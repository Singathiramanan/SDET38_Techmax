package com.techmax.practice;

import org.testng.annotations.Test;

public class TestngInvocationCount {
	@Test
	public void createSupplier(){
		System.out.println("Supplier is created");
	}
	@Test(invocationCount=5,priority=1)
	public void createProduct(){
		System.out.println("Product is created");
	}
	@Test(dependsOnMethods="createProduct")
	public void purchaseProduct(){
		System.out.println("product available in Point Of Sale");
	}
}
