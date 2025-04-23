package com.swd.project;

public class Payment {
	private int paymentID;
	private int employeeID;
	private String paymentDate;
	private int amount;
	
	public Payment(Payment.PaymentBuilder paymentBuilder) {
		this.paymentID = paymentBuilder.paymentID;
		this.employeeID = paymentBuilder.employeeID;
		this.paymentDate = paymentBuilder.paymentDate;
		this.amount = paymentBuilder.amount;
	}
	
	public int getPaymentID() {
		return paymentID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getPaymentDate() {
		return paymentDate;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String asString() {
		return this.getPaymentID() + " "
				+ this.getEmployeeID() + " "
				+ this.getPaymentDate() + " "
				+ this.getAmount();
	}
	
	public static class PaymentBuilder {
		private int paymentID;
		private int employeeID;
		private String paymentDate;
		private int amount;
		
		public PaymentBuilder(int paymentID, int employeeID, String paymentDate, int amount) {
			this.paymentID = paymentID;
			this.employeeID = employeeID;
			this.paymentDate = paymentDate;
			this.amount = amount;
		}

		public void setPaymentID(int paymentID) {
			this.paymentID = paymentID;
		}

		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}

		public void setPaymentDate(String paymentDate) {
			this.paymentDate = paymentDate;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		public Payment build() {
			return new Payment(this);
		}
	}
}
