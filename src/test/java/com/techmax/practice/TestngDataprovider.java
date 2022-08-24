package com.techmax.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDataprovider {
	@Test(dataProvider="categoryAndProduct")
	public void getHeadsetList(String category,String brand,int quantity){
		System.out.println("Category= "+category);
		System.out.println("Brand= "+brand);
		System.out.println("Quantity= "+quantity);
	}
	
	@DataProvider
	public Object[][] categoryAndProduct(){
		Object[][] arr = new Object[5][3];
		
		arr[0][0]="Headset";
		arr[0][1]="Boat";
		arr[0][2]=50;
		
		arr[1][0]="Headset";
		arr[1][1]="Boult";
		arr[1][2]=25;
		
		arr[2][0]="Headset";
		arr[2][1]="Noise";
		arr[2][2]=30;
		
		arr[3][0]="Headset";
		arr[3][1]="Leaf";
		arr[3][2]=20;
		
		arr[4][0]="Headset";
		arr[4][1]="Skull";
		arr[4][2]=25;
		return arr;
	}

}
