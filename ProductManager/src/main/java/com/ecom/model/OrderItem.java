package com.ecom.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int customerId;
	private int vendorId;
	private int totalItems;
	private double totalCost;
	private int addressId;
	private String reason;
	private boolean status;
	private int shippingCharge;
	private String mailSent;
	private double tax;
	private ModeOfPayment modeOfPayment;
	
	@GenericGenerator(name="invoice", strategy="increment")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String invoiceNumber;
	private Date statusDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getShippingCharge() {
		return shippingCharge;
	}
	public void setShippingCharge(int shippingCharge) {
		this.shippingCharge = shippingCharge;
	}
	public String getMailSent() {
		return mailSent;
	}
	public void setMailSent(String mailSent) {
		this.mailSent = mailSent;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}

	public ModeOfPayment getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", customerId=" + customerId + ", vendorId=" + vendorId
				+ ", totalItems=" + totalItems + ", totalCost=" + totalCost + ", addressId=" + addressId + ", reason="
				+ reason + ", status=" + status + ", shippingCharge=" + shippingCharge + ", mailSent=" + mailSent
				+ ", tax=" + tax + ", modeOfPayment=" + modeOfPayment + ", invoiceNumber=" + invoiceNumber
				+ ", statusDate=" + statusDate + "]";
	}
	
	public OrderItem(int orderId, int customerId, int vendorId, int totalItems, double totalCost, int addressId,
			String reason, boolean status, int shippingCharge, String mailSent, double tax, ModeOfPayment modeOfPayment,
			String invoiceNumber, Date statusDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.vendorId = vendorId;
		this.totalItems = totalItems;
		this.totalCost = totalCost;
		this.addressId = addressId;
		this.reason = reason;
		this.status = status;
		this.shippingCharge = shippingCharge;
		this.mailSent = mailSent;
		this.tax = tax;
		this.modeOfPayment = modeOfPayment;
		this.invoiceNumber = invoiceNumber;
		this.statusDate = statusDate;
	}
	public OrderItem() {
		super();
	}

	
	
}
