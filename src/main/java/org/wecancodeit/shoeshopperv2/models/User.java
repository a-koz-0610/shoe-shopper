package org.wecancodeit.shoeshopperv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String username;
	@JsonIgnore
	private String password;

	private String role;

	@OneToMany(mappedBy = "user")
	private Collection<CartItem> cartItems;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public Collection<CartItem> getCartItems() {
		return cartItems;
	}

	protected User() {
	} // JPA

	public User(String username, String password, String role) {
		this.username = username;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
