package com.gluttony;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GluttonService {
    private final ReactiveKafkaConsumerTemplate<String, String> consumerTemplate;

    @Autowired
    public GluttonService(ReactiveKafkaConsumerTemplate<String, String> consumerTemplate) {
        this.consumerTemplate = consumerTemplate;
    }

    private Flux<String> consume() {
        return consumerTemplate
                .receiveAutoAck()
                .map(ConsumerRecord::value)
                .doOnNext(System.out::println);
    }
}
