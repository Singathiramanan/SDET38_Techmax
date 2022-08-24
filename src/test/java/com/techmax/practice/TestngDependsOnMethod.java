package com.techmax.practice;

import org.testng.annotations.Test;

public class TestngDependsOnMethod {
	@Test
	public void createSupplier(){
		System.out.println("Supplier is created");
	}
	@Test(dependsOnMethods="createSupplier")
	public void createProduct(){
		System.out.println("Product is created");
	}
	@Test(dependsOnMethods="createProduct")
	public void purchaseProduct(){
		System.out.println("product available in Point Of Sale");
	}
}
