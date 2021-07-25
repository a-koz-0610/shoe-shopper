package org.wecancodeit.shoeshopperv2.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wecancodeit.shoeshopperv2.models.Product;
import org.wecancodeit.shoeshopperv2.models.ProductNotFoundException;
import org.wecancodeit.shoeshopperv2.models.User;
import org.wecancodeit.shoeshopperv2.models.UserNotFoundException;
import org.wecancodeit.shoeshopperv2.repositories.ProductRepository;
import org.wecancodeit.shoeshopperv2.repositories.UserRepository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Optional;

@Controller
public class ProductController {

	@Resource
	private ProductRepository productRepo;

	@Resource
	private ImageUploadService uploader;

	@Resource
	private UserRepository userRepo;

	@RequestMapping("/login")
	public String login() {
		// cartItemRepo.deleteAll();
		return "login";
	}

	@RequestMapping("/product")
	public String findOneItem(@RequestParam(value = "id") long productId, Principal principal, Model model)
			throws ProductNotFoundException, UserNotFoundException {

		String loggedUser = principal.getName().toString();
		Optional<User> foundUser = userRepo.findByUsername(loggedUser);

		if (foundUser.isPresent()) {
			Optional<Product> foundProduct = productRepo.findById(productId);

			if (foundProduct.isPresent()) {
				model.addAttribute("productModel", foundProduct.get());
				model.addAttribute("userModel", foundUser.get());
				return "product";
			}
			throw new ProductNotFoundException();
		}
		throw new UserNotFoundException();
	}

	// for testing purposes only, to pull one item
	public String findOneItem(@RequestParam(value = "id") long productId, Model model) throws ProductNotFoundException {

		Optional<Product> foundProduct = productRepo.findById(productId);

		if (foundProduct.isPresent()) {
			model.addAttribute("productModel", foundProduct.get());
			return "product";
		}
		throw new ProductNotFoundException();

	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("productsModel", productRepo.findAll());
		return "products";
	}

	@RequestMapping("/products")
	public String findAllItems(Model model) {
		model.addAttribute("productsModel", productRepo.findAll());
		return "products";

	}

	@PostMapping("/add-product")
	public String addItemWithImage(@RequestParam(value = "productName", required = true) String productName,
			@RequestParam(value = "productDescription", required = true) String productDescription,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile) throws Exception {

		String virtualFileUrl = uploader.uploadMultipartFile(imageFile);
		System.out.println(productName);
		productRepo.save(new Product(productName, productDescription, "/uploads/" + virtualFileUrl));

		return "redirect:/products";
	}

	public String addItem(@RequestParam(value = "productName", required = true) String productName,
			@RequestParam(value = "productDescription", required = true) String productDescription) {

		productRepo.save(new Product(productName, productDescription, "/uploads/" + ""));
		return "redirect:/products";
	}

	@GetMapping("/uploads/{file:.+}") // allows "." to be part of PathVariable instead of truncating it
	public void serveImage(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("file") String fileName) throws Exception {

		// Resolve path of requested file
		File requestedFile = uploader.getUploadedFile(fileName);

		// Ensure requested item exists and is a file
		if (!requestedFile.exists() || !requestedFile.isFile()) {
			throw new Exception();
		}

		// Determine and set correct content type of response
		String fileContentType = Files.probeContentType(requestedFile.toPath());
		response.setContentType(fileContentType);

		// Serve file by streaming it directly to the response
		InputStream in = new FileInputStream(requestedFile);
		IOUtils.copy(in, response.getOutputStream());
	}

}
