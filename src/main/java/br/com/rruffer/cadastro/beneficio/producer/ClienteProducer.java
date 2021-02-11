package br.com.rruffer.cadastro.beneficio.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.util.JsonUtil;

@Component
public class ClienteProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queue;
	
	public void send(String order) {
		rabbitTemplate.convertAndSend(queue.getName(), order);
	}
	
	public void send(ClienteDTO clienteDTO) {
		String cliente = JsonUtil.serializarJSON(clienteDTO, true);
		rabbitTemplate.convertAndSend(queue.getName(), cliente);
	}
	
}
