package org.wecancodeit.shoeshopperv2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.shoeshopperv2.models.CartItem;
import org.wecancodeit.shoeshopperv2.models.Product;

import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	Optional<CartItem> findByProduct(Product product);

}
 