package org.wecancodeit.shoeshopperv2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.shoeshopperv2.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
