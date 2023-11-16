package se.topofminds.product.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "Product")
public class ProductEntity {
	private @Id @GeneratedValue(strategy = IDENTITY) long id;
	private String sku;
	private String name;
	private Instant creationDate;
	private Instant lastModified;
	
	@ManyToMany(mappedBy = "products")
	private List<CategoryEntity> categories;
	
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
