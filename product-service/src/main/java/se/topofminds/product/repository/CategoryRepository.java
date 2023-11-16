package se.topofminds.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.topofminds.product.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
