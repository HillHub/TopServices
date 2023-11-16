package se.topofminds.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import se.topofminds.product.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	Optional<ProductEntity> findBySku(String sku);
	List<ProductEntity> findBySkuIn(List<String> skus);
}
