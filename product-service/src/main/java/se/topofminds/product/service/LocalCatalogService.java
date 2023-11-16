package se.topofminds.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import se.topofminds.product.configuration.ProductConfig;
import se.topofminds.product.controller.CreateCategoryRequest;
import se.topofminds.product.domain.Category;
import se.topofminds.product.domain.Product;
import se.topofminds.product.entity.CategoryEntity;
import se.topofminds.product.entity.ProductEntity;
import se.topofminds.product.repository.CategoryRepository;
import se.topofminds.product.repository.ProductRepository;

@Service
@AllArgsConstructor
@Slf4j
public class LocalCatalogService implements CatalogService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ProductConfig config;

	@Override
	public Product getProduct(String sku) throws Exception {
		log.error("Funkar det här då?!");
		Optional<ProductEntity> productEntity = productRepository.findBySku(sku);
		if (productEntity.isPresent()) {
			ProductEntity entity = productEntity.get();
			return mapFromEntity(entity);
		} else {
			log.error("Could not get product from sku: {}", sku);
			throw new Exception("TODO: Change to specific exception");
		}
	}

	@Override
	public Category getCategory(Long id) throws Exception {
		Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
		if (categoryEntity.isPresent()) {
			CategoryEntity entity = categoryEntity.get();
			return mapFromEntity(entity);
		} else {
			log.info("Could not get category from id: {}", id);
			throw new Exception("TODO: Change to specific exception");
		}
	}

	@Override
	public Category createCategory(CreateCategoryRequest request) {
		System.out.println("skus:" + request.skus());
		List<ProductEntity> productEntities = productRepository.findBySkuIn(request.skus());
		CategoryEntity entity = CategoryEntity.builder()
				.name(request.name())
				.description(request.description())
				.products(productEntities)
				.build();
		System.out.println(entity);
		Category category = mapFromEntity(categoryRepository.save(entity));
		kafkaTemplate.send(config.topics().category(), formatToJson(category));
		
		return category;
	}

	@Override
	public List<Category> getCategories() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		return entities.stream().map(c -> mapFromEntity(c)).collect(Collectors.toList());
	}
	
	private String formatToJson(Category category) {
		try {
			return new JsonMapper().writeValueAsString(category);
		} catch (JsonProcessingException e) {
			log.error("Could not create json from category with name: {}", category.name(), e);
			return "";
		}
	}
	
	private Product mapFromEntity(ProductEntity entity) {
		return new Product(entity.getSku(), entity.getName());
	}

	private Category mapFromEntity(CategoryEntity entity) {
		List<Product> products = entity.getProducts().stream()
				.map(p -> mapFromEntity(p))
				.collect(Collectors.toList());
		return new Category(entity.getId(), entity.getName(), entity.getDescription(), products);
	}
}
