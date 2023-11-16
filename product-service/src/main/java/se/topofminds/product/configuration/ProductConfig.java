package se.topofminds.product.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("integration")
public record ProductConfig(
        Brink brink,
        Topic topics) {
	
	public record Brink(
			String tokenUrl,
			String clientId,
			String clientSecret,
			String managementUrl,
			String shopperUrl,
			String orderUrl,
			String storeGroupId) {
	}
	
	public record Topic(
			String product,
			String category) {
	}
}

