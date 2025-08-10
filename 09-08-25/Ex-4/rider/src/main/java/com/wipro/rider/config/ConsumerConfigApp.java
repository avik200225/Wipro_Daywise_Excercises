package com.wipro.rider.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.wipro.rider.entity.RideBooking;
 
@Configuration
public class ConsumerConfigApp {
 
	
	@Bean
    public ConsumerFactory<String, RideBooking> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer());
    }
	
	@Bean
	public JsonDeserializer<RideBooking> jsonDeserializer() {
	    JsonDeserializer<RideBooking> jsonDeserializer = new JsonDeserializer<>(RideBooking .class)
	    		.ignoreTypeHeaders();
	    //jsonDeserializer.addTrustedPackages("*");
	    return jsonDeserializer;
	}

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RideBooking> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RideBooking> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
