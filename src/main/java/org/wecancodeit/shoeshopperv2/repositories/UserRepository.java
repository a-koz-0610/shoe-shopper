package org.wecancodeit.shoeshopperv2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.shoeshopperv2.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {


	Optional<User> findByUsername(String name);

}
