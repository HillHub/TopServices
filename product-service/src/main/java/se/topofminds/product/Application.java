package se.topofminds.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

import se.topofminds.product.configuration.ProductConfig;

@EnableKafka
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({ProductConfig.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
