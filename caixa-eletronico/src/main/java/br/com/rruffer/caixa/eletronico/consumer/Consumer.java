package br.com.rruffer.caixa.eletronico.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.rruffer.caixa.eletronico.dto.ClienteDTO;
import br.com.rruffer.caixa.eletronico.util.JsonUtil;

@Component
public class Consumer {

	@RabbitListener(queues ={"${queue.order.name}"})
	public void receive(@Payload String mensagem) {
		ClienteDTO cliente = JsonUtil.deserializarJSON(mensagem, ClienteDTO.class);
		System.out.println(mensagem);
	}
	
}
