package br.com.rruffer.cadastro.beneficio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.rruffer.cadastro.beneficio.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Long> {

	@Query("{ 'cpf' : ?0 }")
	Cliente findByCpf(String cpf);
	
}
