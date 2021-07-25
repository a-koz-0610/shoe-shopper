package org.wecancodeit.shoeshopperv2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wecancodeit.shoeshopperv2.controllers.CartItemController;
import org.wecancodeit.shoeshopperv2.controllers.ImageUploadService;
import org.wecancodeit.shoeshopperv2.controllers.ProductController;
import org.wecancodeit.shoeshopperv2.repositories.CartItemRepository;
import org.wecancodeit.shoeshopperv2.repositories.ProductRepository;
import org.wecancodeit.shoeshopperv2.repositories.UserRepository;
import static org.hamcrest.CoreMatchers.*;
import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class SmokeTest {

	@Resource
	private ProductRepository productRepo;

	@Resource
	private ProductController productController;

	@Resource
	private CartItemRepository cartItemRepo;

	@Resource
	private CartItemController cartItemController;

	@Resource
	private ImageUploadService imageUploadService;
	
	@Resource
	private UserRepository userRepo;

	@Test
	public void contextLoads() throws Exception {
		assertThat(productRepo, is(notNullValue()));
		assertThat(productController, is(notNullValue()));
		assertThat(cartItemRepo, is(notNullValue()));
		assertThat(cartItemController, is(notNullValue()));
		assertThat(imageUploadService, is(notNullValue()));
		assertThat(userRepo, is(notNullValue()));
	}

}
