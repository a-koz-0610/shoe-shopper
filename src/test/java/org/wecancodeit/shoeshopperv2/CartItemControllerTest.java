package org.wecancodeit.shoeshopperv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.wecancodeit.shoeshopperv2.controllers.CartItemController;
import org.wecancodeit.shoeshopperv2.models.CartItem;
import org.wecancodeit.shoeshopperv2.models.CartNotFoundException;
import org.wecancodeit.shoeshopperv2.models.User;
import org.wecancodeit.shoeshopperv2.repositories.CartItemRepository;
import org.wecancodeit.shoeshopperv2.repositories.ProductRepository;
import org.wecancodeit.shoeshopperv2.repositories.UserRepository;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CartItemControllerTest {

	@InjectMocks
	private CartItemController underTest;

	@Mock
	private CartItem cartItemOne;

	@Mock
	private CartItem cartItemTwo;

	@Mock
	private CartItemRepository cartItemRepo;

	@Mock
	private ProductRepository productRepo;

	@Mock
	private UserRepository userRepo;

	@Mock
	private Model model;

	@Mock
	Principal principal;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void shouldAddCartItemsToModel() throws CartNotFoundException {
		User user = new User("admin", "admin", "ADMIN");
		when(userRepo.findByUsername("admin")).thenReturn(Optional.of(user));
		Collection<CartItem> cartItems = Arrays.asList(cartItemOne, cartItemTwo);
		when(cartItemRepo.findAll()).thenReturn(cartItems);
		underTest.findAllCartItems(model);
		verify(model).addAttribute("cartItemsModel", cartItems);
	}

}
