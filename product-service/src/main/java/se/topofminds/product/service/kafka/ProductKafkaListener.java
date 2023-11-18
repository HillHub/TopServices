package se.topofminds.product.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import se.topofminds.product.entity.model.ProductMaster;
import se.topofminds.product.entity.model.ProductVariation;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductKafkaListener {

	@KafkaListener(topics = "${integration.topics.product}")
	public void listen(@Payload String record) {
		log.info("Recieved record: " + record);

		boolean master = false;
		boolean variation = false;
		if (master) {

			ProductMaster productMaster;
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				// objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				// false);

				productMaster = objectMapper.readValue(record, ProductMaster.class);
				log.info(productMaster.toString());

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (variation) {

			ProductVariation productVariation;
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				// objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				// false);

				productVariation = objectMapper.readValue(record, ProductVariation.class);
				log.info(productVariation.toString());

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}
}
