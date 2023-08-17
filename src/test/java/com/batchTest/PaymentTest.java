package com.batchTest;

import org.testng.annotations.Test;

public class PaymentTest {
	
@Test
public void paymentInDollar() {
	System.out.println("payment done in dollar");
}
@Test
public void paymentInRupees() {
	System.err.println("payment done in rupees");
}
}
