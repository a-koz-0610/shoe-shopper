package org.wecancodeit.shoeshopperv2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Product product;

	@ManyToOne
	private User user;

	public long getId() {

		return id;
	}

	public Product getProduct() {

		return product;
	}

	public User getUser() {
		return user;
	}

	public CartItem() {

	}

	public CartItem(Product product) {
		this.product = product;
	}

	public CartItem(Product product, User user) {
		this.product = product;
		this.user = user;
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
		CartItem other = (CartItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
