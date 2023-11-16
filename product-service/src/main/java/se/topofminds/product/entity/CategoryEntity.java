package se.topofminds.product.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Category")
public class CategoryEntity {
	private @Id @GeneratedValue(strategy = IDENTITY) Long id;
	private String name;
	private String description;
	private Instant creationDate;
	private Instant lastModified;
	
	@ManyToMany
	@JoinTable(
			  name = "CategoryAssignment", 
			  joinColumns = @JoinColumn(name = "categoryId"), 
			  inverseJoinColumns = @JoinColumn(name = "productId"))
	private List<ProductEntity> products;
	
	@PreUpdate
    @PrePersist
    void beforeSave() {
        Instant now = Instant.now();
        setLastModified(now);
        if (getCreationDate() == null) {
            setCreationDate(now);
        }
    };
}
