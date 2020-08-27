package com.ecom.model;

import java.sql.Date;
import java.time.LocalDate;

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

	private LocalDate approveDate;
	
	
	
	public LocalDate getApproveDate() {
		return approveDate;
	}

	

	public void setApproveDate(LocalDate approveDate) {
		this.approveDate = approveDate;
	}



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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualPrice == null) ? 0 : actualPrice.hashCode());
		result = prime * result + ((approveDate == null) ? 0 : approveDate.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((highlights == null) ? 0 : highlights.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((productCat == null) ? 0 : productCat.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productSubCat == null) ? 0 : productSubCat.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((skuCode == null) ? 0 : skuCode.hashCode());
		result = prime * result + ((specification == null) ? 0 : specification.hashCode());
		result = prime * result + ((strImage == null) ? 0 : strImage.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		ProductMaster other = (ProductMaster) obj;
		if (actualPrice == null) {
			if (other.actualPrice != null)
				return false;
		} else if (!actualPrice.equals(other.actualPrice))
			return false;
		if (approveDate == null) {
			if (other.approveDate != null)
				return false;
		} else if (!approveDate.equals(other.approveDate))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (highlights == null) {
			if (other.highlights != null)
				return false;
		} else if (!highlights.equals(other.highlights))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (productCat == null) {
			if (other.productCat != null)
				return false;
		} else if (!productCat.equals(other.productCat))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productSubCat == null) {
			if (other.productSubCat != null)
				return false;
		} else if (!productSubCat.equals(other.productSubCat))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (skuCode == null) {
			if (other.skuCode != null)
				return false;
		} else if (!skuCode.equals(other.skuCode))
			return false;
		if (specification == null) {
			if (other.specification != null)
				return false;
		} else if (!specification.equals(other.specification))
			return false;
		if (strImage == null) {
			if (other.strImage != null)
				return false;
		} else if (!strImage.equals(other.strImage))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}




	
}
