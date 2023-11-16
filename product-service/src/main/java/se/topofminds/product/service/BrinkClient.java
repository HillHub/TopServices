package se.topofminds.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "brinkClient", url = "${integration.brink.management-url}")
public interface BrinkClient {
	
	// TODO: Fixa authorization
	@GetMapping("/product/product-parents/{sku}")
	String getProduct(@PathVariable String sku, @RequestHeader("Authorization") String auth);
}
