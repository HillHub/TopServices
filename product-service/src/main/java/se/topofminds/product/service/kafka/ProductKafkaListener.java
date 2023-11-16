package se.topofminds.product.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductKafkaListener {

    @KafkaListener(topics = "${integration.topics.product}")
    public void listen(@Payload String record) {
    	log.info("Recieved record: " + record);
    }
}
