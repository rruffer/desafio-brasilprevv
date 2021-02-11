package br.com.rruffer.cadastro.beneficio.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.entity.Cliente;
import br.com.rruffer.cadastro.beneficio.producer.ClienteProducer;
import br.com.rruffer.cadastro.beneficio.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteProducer clienteProducer;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private ModelMapper mapper;
	
	public ClienteDTO consultar(String cpf) throws Exception {
		
		Cliente cliente = clienteRepository.findByCpf(cpf);
		if(cliente != null) {
			ClienteDTO clienteDTO = mapper.map(cliente, ClienteDTO.class);			
			return clienteDTO;
		}

		return null;
		
	}
	
	public Cliente salvar(ClienteDTO clienteDTO) throws Exception {
		
		if (clienteRepository.findByCpf(clienteDTO.getCpf()) != null) {
			return null;
		} else {
			Cliente cliente = mapper.map(clienteDTO, Cliente.class);
			cliente.setId(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
			clienteRepository.save(cliente);
			
			clienteDTO.setId(cliente.getId());
			clienteProducer.send(clienteDTO);
			
			return cliente;
		}
		
	}
	
	public void salvar(Cliente cliente) throws Exception{
		cliente.setId(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
		clienteRepository.save(cliente);
		ClienteDTO clienteDTO = mapper.map(cliente, ClienteDTO.class);
		clienteProducer.send(clienteDTO);
	}
	
}
