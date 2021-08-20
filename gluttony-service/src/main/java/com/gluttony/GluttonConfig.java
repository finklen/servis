package com.gluttony;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.Map;

@Configuration
public class GluttonConfig {
    ReactiveKafkaConsumerTemplate<String, String> consumerTemplate(KafkaProperties properties) {
        Map<String, Object> props = properties.buildProducerProperties();
        return new ReactiveKafkaConsumerTemplate<>(ReceiverOptions.create(props));
    }
}
