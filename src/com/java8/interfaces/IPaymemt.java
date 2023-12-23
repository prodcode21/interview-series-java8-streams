package com.java8.interfaces;


@FunctionalInterface
public interface IPaymemt  {

	void dopayment();
	
	static void calculateOffer()
	{
		
	}
	
	static void calculateOffer2()
	{
		
	}
	
	default void selectPaymentType()
	{
		
	}
	
	default void selectPaymentType2()
	{
		
	}
	
	//summary
	// only one abstract method
	// n number of static and default methods
	//cannot extend interface
	
	
	
}
