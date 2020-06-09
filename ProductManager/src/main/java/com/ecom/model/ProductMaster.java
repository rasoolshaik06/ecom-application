package com.ecom.model;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	private String productName;
	
	private String productCat;
	
	private String strImage;
	
	private String skuCode;
	
	private float price;
	
	private String highlights;
	
	private String companyName;
	
	private String productSubCat;
	
	private String specification;
	
	private Integer weight;
	
	private String productType;
	
	private String actualPrice;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCat() {
		return productCat;
	}

	public void setProductCat(String productCat) {
		this.productCat = productCat;
	}

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getHighlights() {
		return highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProductSubCat() {
		return productSubCat;
	}

	public void setProductSubCat(String productSubCat) {
		this.productSubCat = productSubCat;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(String actualPrice) {
		this.actualPrice = actualPrice;
	}

	@Override
	public String toString() {
		return "ProductMaster [productId=" + productId + ", productName=" + productName + ", productCat=" + productCat
				+ ", strImage=" + strImage + ", skuCode=" + skuCode + ", price=" + price + ", highlights=" + highlights
				+ ", companyName=" + companyName + ", productSubCat=" + productSubCat + ", specification="
				+ specification + ", weight=" + weight + ", productType=" + productType + ", actualPrice=" + actualPrice
				+ "]";
	}


	
}
