package generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    private final ReactiveKafkaProducerTemplate<String, String> producerTemplate;

    private String topic;

    @Autowired
    public GeneratorService(ReactiveKafkaProducerTemplate<String, String> producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void publish(String data) {
        producerTemplate
                .send(topic, data)
                .doOnSuccess(System.out::println)
                .subscribe();

    }
}
