package com.ecom.model;

public enum ModeOfPayment {

	CASHONPAYMENT("CashOnDelivery"),
	CARDONPAYMENT("debit/credit card payment");
	private final String payment;
	
	ModeOfPayment(String payment) {
	
		this.payment=payment;
	}
	
	public String getPayment() {
		return payment;
	}


}
