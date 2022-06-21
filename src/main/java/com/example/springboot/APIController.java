package com.example.springboot;

import com.example.springboot.dbmodels.Product;
import com.example.springboot.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {

	@Autowired
	private IProductRepository iceCreamRepo;

	@GetMapping("/")
	public String index() {
		return "Welcome to Ice Cream Store";
	}

	@PostMapping("/product/add")
	public String addProduct(@RequestBody Product iceCream) {
		iceCreamRepo.save(iceCream);
		return "New Product Added";
	}

	@GetMapping("/product/list")
	public Iterable<Product> getProducts() {
		return iceCreamRepo.findAll();
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return iceCreamRepo.getById(id);
	}

	@GetMapping("/order/add")
	public String addOrder(@RequestBody UserOrder userOrder) {

		return "add new order";
	}

	@GetMapping("/order/list")
	public String getOrders() {
		return "list order";
	}
}