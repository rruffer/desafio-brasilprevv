package br.com.rruffer.cadastro.beneficio.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.repository.ClienteRepository;
import br.com.rruffer.cadastro.beneficio.services.ClienteService;
import br.com.rruffer.cadastro.beneficio.util.JsonUtil;

@Component
public class ClienteConsumer {
	
	@Autowired
	private ClienteService clienteService;

	@RabbitListener(queues = "${queue.calculo}")
	public void calculo(String msg) {
		ClienteDTO clienteDTO = JsonUtil.deserializarJSON(msg, ClienteDTO.class);
		
		
		
	}
	
}
