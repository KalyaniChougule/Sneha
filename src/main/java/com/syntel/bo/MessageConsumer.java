package com.syntel.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/* 
 * This class can read messages from Kafka message broker. The Topic information is stored
 * in application.yml under "producer" group
 */
public class MessageConsumer extends Thread {
	private final ConsumerConnector consumer;
	private final String topic;
	private final String group;
	private final String consumername;
	private final String zookeeperHost;
	private final String port;
	
	final Logger LOG = Logger.getLogger(MessageConsumer.class);
 

	public MessageConsumer(String topic, String grp, String name, String zookeeperhost,String port) {
		this.topic = topic;
		this.group = grp;
		this.consumername = name;
		this.zookeeperHost = zookeeperhost;
		this.port= port;
		consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());
	}

	private ConsumerConfig createConsumerConfig() {
		Properties props = new Properties();
		props.put("zookeeper.connect", zookeeperHost + ":" + port);
		props.put("group.id", group);
		props.put("zookeeper.session.timeout.ms", "100000");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");

		return new ConsumerConfig(props);
	}

	public void run() {
		try {

			Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
			topicCountMap.put(topic, new Integer(1));
			Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
			KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
			ConsumerIterator<byte[], byte[]> it = stream.iterator();
			while (it.hasNext())
				System.out.println("consumer  " + consumername + " :" + new String(it.next().message()));
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}
	}
}
