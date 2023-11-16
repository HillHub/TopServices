package se.topofminds.product.domain;

import java.util.List;

public record Category(
		Long id,
		String name,
		String description,
		List<Product> products) {
}
