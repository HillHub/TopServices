package se.topofminds.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import se.topofminds.product.domain.Category;
import se.topofminds.product.domain.Product;
import se.topofminds.product.service.CatalogService;
import se.topofminds.product.service.ProductService;

@RequestMapping("/catalog")
@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {
	
	private final CatalogService catalogService;
	private final ProductService productService;

	@GetMapping("/products/{sku}")
	public ResponseEntity<Product> getProduct(@PathVariable String sku) {
		try {
			return new ResponseEntity<Product>(catalogService.getProduct(sku), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/products/{sku}/details")
	public String getProductDetails(@PathVariable String sku) {
		return productService.getProductDetails(sku);
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Long id) {
		try {
			return new ResponseEntity<Category>(catalogService.getCategory(id), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryRequest request) {
		return new ResponseEntity<Category>(catalogService.createCategory(request), HttpStatus.OK);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories() {
		return new ResponseEntity<List<Category>>(catalogService.getCategories(), HttpStatus.OK);
	}
}
