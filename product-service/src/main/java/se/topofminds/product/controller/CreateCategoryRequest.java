package se.topofminds.product.controller;

import java.util.List;

public record CreateCategoryRequest(
		String name,
		String description,
		List<String> skus) {
}
