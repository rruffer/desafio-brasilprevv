package br.com.rruffer.cadastro.beneficio.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	@Value("${queue.cadastro}")
	private String queue;
	
	@Bean
	public Queue queue() {
		return new Queue(queue, true);
	}
	
	@Bean
	public CachingConnectionFactory rabbitConnectionFactory(RabbitProperties config)
			throws Exception {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.getRabbitConnectionFactory().setUri("amqps://umemkxbp:0GRU0yvX6DMbIqNDBcmb3YwOnxLgG5fj@jackal.rmq.cloudamqp.com/umemkxbp");
		return connectionFactory;
	}
	
	
}
