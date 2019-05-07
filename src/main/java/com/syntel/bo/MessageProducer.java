package com.syntel.bo;

import java.util.Properties;

import javax.annotation.PostConstruct;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* 
 * This class can send message to Kafka message broker. The Topic information is stored
 * in application.yml under "producer" group
 */
@Component
public class MessageProducer {
	private static   Producer<String, String> producer;
	
	@Value("${producer.topic}")
	private String topic;
	@Value("${producer.serializerClass}")
	private String serializerClass;
	@Value("${producer.broker}")
	private String broker;
	@Value("${producer.acknowledgement}")
	private String acks;
	
	@Value("${producer.port}")
	private String port;
	
	@PostConstruct
	public void init() {
		Properties props = new Properties();
		props.put("serializer.class", serializerClass);
		props.put("metadata.broker.list", broker+":"+port);
		props.put("request.required.acks", acks);
	//	producer = new Producer<String, String>(new ProducerConfig(props));
	}

	public String send(String message) {
		try {
			producer.send(new KeyedMessage<String, String>(topic, message));
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Sent Message Successfully";
	}

}
