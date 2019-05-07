package com.syntel.bo;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* 
 * This class initializes MessageConsumer which starts listening to Kafka messages
 */
@Component
public class ConsumerHandler {
	@Value("${consumer.topic}")
	private String topic;
	@Value("${consumer.group}")
	private String group;
	@Value("${consumer.zookeeperhost}")
	private String zookeeperhost;
	@Value("${consumer.consumername}")
	private String consumername;
	@Value("${consumer.port}")
	private String port;
	
	MessageConsumer consumer;


	public void start() {
		consumer = new MessageConsumer(topic, group, consumername, zookeeperhost, port);
		consumer.start();
	}

	@PreDestroy
	public void destroy() {
		consumer.interrupt();
	}

}
