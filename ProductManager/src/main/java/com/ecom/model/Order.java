package com.ecom.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import net.bytebuddy.implementation.bind.annotation.Default;



@Entity
@Table(name="order_list")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderItemId;

	private int orderId;

	private int vendorProductId;

	private int quantity;

	private double priceEach;

	private double priceTotal;

	private int productId;

	private boolean status;

	private LocalDate approveDate;

	private int userId;

	private Date reject_date;

	private Date dispatch_date;

	private Date delivary_date;

	private String reason;

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId; 
	}

	public int getVendorProductId() {
		return vendorProductId;
	}

	public void setVendorProductId(int vendorProductId) {
		this.vendorProductId = vendorProductId;
	}

	public int getQuantity() {
		return quantity;
	}
 
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}






	public LocalDate getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(LocalDate approveDate) {
		this.approveDate = approveDate;
	}



	public int getByUsedId() {
		return userId;
	}

	public void setByUsedId(int byUsedId) {
		this.userId = byUsedId;
	}

	public Date getReject_date() {
		return reject_date;
	}

	public void setReject_date(Date reject_date) {
		this.reject_date = reject_date;
	}

	public Date getDispatch_date() {
		return dispatch_date;
	}

	public void setDispatch_date(Date dispatch_date) {
		this.dispatch_date = dispatch_date;
	}

	public Date getDelivary_date() {
		return delivary_date;
	}

	public void setDelivary_date(Date delivary_date) {
		this.delivary_date = delivary_date;
	}


	@Override
	public String toString() {
		return "Order [orderItemId=" + orderItemId + ", orderId=" + orderId + ", vendorProductId=" + vendorProductId
				+ ", quantity=" + quantity + ", priceEach=" + priceEach + ", priceTotal=" + priceTotal + ", productId="
				+ productId + ", status=" + status + ", approveDate=" + approveDate + ", byUsedId=" + userId
				+ ", reject_date=" + reject_date + ", dispatch_date=" + dispatch_date + ", delivary_date="
				+ delivary_date + ", reason=" + reason + "]";
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approveDate == null) ? 0 : approveDate.hashCode());
		result = prime * result + userId;
		result = prime * result + ((delivary_date == null) ? 0 : delivary_date.hashCode());
		result = prime * result + ((dispatch_date == null) ? 0 : dispatch_date.hashCode());
		result = prime * result + orderId;
		result = prime * result + orderItemId;
		long temp;
		temp = Double.doubleToLongBits(priceEach);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result + quantity;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((reject_date == null) ? 0 : reject_date.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + vendorProductId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (approveDate == null) {
			if (other.approveDate != null)
				return false;
		} else if (!approveDate.equals(other.approveDate))
			return false;
		if (userId != other.userId)
			return false;
		if (delivary_date == null) {
			if (other.delivary_date != null)
				return false;
		} else if (!delivary_date.equals(other.delivary_date))
			return false;
		if (dispatch_date == null) {
			if (other.dispatch_date != null)
				return false;
		} else if (!dispatch_date.equals(other.dispatch_date))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderItemId != other.orderItemId)
			return false;
		if (Double.doubleToLongBits(priceEach) != Double.doubleToLongBits(other.priceEach))
			return false;
		if (Double.doubleToLongBits(priceTotal) != Double.doubleToLongBits(other.priceTotal))
			return false;
		if (productId != other.productId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reject_date == null) {
			if (other.reject_date != null)
				return false;
		} else if (!reject_date.equals(other.reject_date))
			return false;
		if (status != other.status)
			return false;
		if (vendorProductId != other.vendorProductId)
			return false;
		return true;
	}

	
	
	
}
