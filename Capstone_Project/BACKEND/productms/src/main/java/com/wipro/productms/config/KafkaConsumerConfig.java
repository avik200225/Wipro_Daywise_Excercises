package com.wipro.productms.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
  @Bean
  public ConsumerFactory<String, Object> consumerFactory() {
    Map<String, Object> cfg = new HashMap<>();
    cfg.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    cfg.put(ConsumerConfig.GROUP_ID_CONFIG, "productms-group");
    cfg.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    cfg.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    cfg.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaConsumerFactory<>(cfg);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Object> f = new ConcurrentKafkaListenerContainerFactory<>();
    f.setConsumerFactory(consumerFactory());
    return f;
  }
}
