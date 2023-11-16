package se.topofminds.product.service;

import java.util.List;

import se.topofminds.product.controller.CreateCategoryRequest;
import se.topofminds.product.domain.Category;
import se.topofminds.product.domain.Product;

public interface CatalogService {
	Product getProduct(String sku) throws Exception;
	Category getCategory(Long id) throws Exception;
	Category createCategory(CreateCategoryRequest request);
	List<Category> getCategories();
}
