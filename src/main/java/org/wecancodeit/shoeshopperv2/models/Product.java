package org.wecancodeit.shoeshopperv2.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {

	private String productName;
	private String imageUrl;

	@Lob
	private String productDescription;

	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "product")
	private Collection<CartItem> cartItems;

	public String getProductName() {
		return productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public long getId() {
		return id;
	}

	public Collection<CartItem> getCartItems() {
		return cartItems;
	}

	protected Product() {
	}

	public Product(String productName, String productDescription, String imageUrl) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
