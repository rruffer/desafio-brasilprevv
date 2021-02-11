package br.com.rruffer.cadastro.beneficio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rruffer.cadastro.beneficio.entity.Cliente;
import br.com.rruffer.cadastro.beneficio.repository.ClienteRepository;
import br.com.rruffer.cadastro.beneficio.services.SequenceGeneratorService;

@SpringBootTest
class CadastroBeneficioApplicationTests {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void gravandoCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf("11111111");
		cliente.setEmail("tgjhlgbjhbk");
		cliente.setNome("kjlçkjcv");
		cliente.setQtdAnosAposentadoria(10);
		cliente.setTotalSaldoAposentadoria(10l);
		
		cliente.setId(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
		
		clienteRepository.save(cliente);
		
		assertTrue(clienteRepository.existsById(cliente.getId()));
		
	}
	

}
